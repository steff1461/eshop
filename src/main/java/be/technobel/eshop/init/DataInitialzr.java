package be.technobel.eshop.init;

import be.technobel.eshop.model.enumeration.EPaymentMode;
import be.technobel.eshop.model.form.CategoryForm;
import be.technobel.eshop.model.form.OrderForm;
import be.technobel.eshop.model.form.ProductForm;
import be.technobel.eshop.model.form.UserForm;
import be.technobel.eshop.service.impl.CategoryServiceImpl;
import be.technobel.eshop.service.impl.OrderServiceImpl;
import be.technobel.eshop.service.impl.ProductServiceImpl;
import be.technobel.eshop.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
@Component
public class DataInitialzr implements InitializingBean {

    private final UserServiceImpl userService;
    private final CategoryServiceImpl categoryService;
    private final ProductServiceImpl productService;
    private final OrderServiceImpl orderService;

    public DataInitialzr(UserServiceImpl userService, CategoryServiceImpl categoryService, ProductServiceImpl productService, OrderServiceImpl orderService) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.productService = productService;
        this.orderService = orderService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        log.info("initialization");

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                "admin_init", "1234", Arrays.asList(
                new SimpleGrantedAuthority("USER"),
                new SimpleGrantedAuthority("ADMIN"))
        );
        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(authenticationToken);

        List<UserForm> users = Arrays.asList(
                UserForm.builder()
                        .username("greg")
                        .password("1234")
                        .address("Rue de fer 33")
                        .deliveryAddress("Rue du paradis 19")
                        .email("steffen.w@outlook.be")
                        .roles(Collections.singletonList(
                                "USER"
                        ))
                        .build(),
                UserForm.builder()
                        .username("admin")
                        .password("1234")
                        .email("test@outlook.be")
                        .roles(Arrays.asList(
                                "USER", "ADMIN"
                        ))
                        .build()
        );


        users.forEach(userService::save);



        List<CategoryForm> categories = Arrays.asList(

                CategoryForm.builder().name("Bonbons").build(),
                CategoryForm.builder().name("Chocolats").build(),
                CategoryForm.builder().name("Mort aux rats").build(),
                CategoryForm.builder().name("Chiclette").build()
        );

        categories.forEach(categoryService::save);

        List<ProductForm> products = Arrays.asList(

                ProductForm.builder().categoryId(3L).name("Candy").price(5.3F).weight(12F).build(),
                ProductForm.builder().categoryId(4L).name("Chique").price(6.9F).weight(12F).build(),
                ProductForm.builder().categoryId(5L).name("Test").price(5.11F).weight(12F).build(),
                ProductForm.builder().categoryId(3L).name("No idea").price(12.0F).weight(12F).build(),
                ProductForm.builder().categoryId(4L).name("Coco").price(3.25F).weight(12F).build(),
                ProductForm.builder().categoryId(6L).name("Haribo").price(1.99F).weight(12F).build()
        );

        products.forEach(productService::save);


        List<OrderForm> orders = Arrays.asList(

                OrderForm.builder()
                        .deliveryDate(LocalDate.now())
                        .idCustomer(2L)
                        .paymentMode(EPaymentMode.Bancontact)
                        .productsId(Arrays.asList(7L,12L,11L))
                        .build(),

                OrderForm.builder()
                        .deliveryDate(LocalDate.now())
                        .idCustomer(1L).paymentMode(EPaymentMode.Bancontact)
                        .productsId(Arrays.asList(9L,8L,11L))
                        .build()
        );

        orders.forEach(orderService::save);

        SecurityContextHolder.clearContext();

    }
}
