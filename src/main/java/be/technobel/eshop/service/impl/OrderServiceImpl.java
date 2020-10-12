package be.technobel.eshop.service.impl;

import be.technobel.eshop.mapper.BaseMapper;
import be.technobel.eshop.model.dto.OrderDto;
import be.technobel.eshop.model.entity.Order;
import be.technobel.eshop.model.entity.Product;
import be.technobel.eshop.model.entity.User;
import be.technobel.eshop.model.form.OrderForm;
import be.technobel.eshop.model.simpleview.UserView;
import be.technobel.eshop.repository.OrderRepository;
import be.technobel.eshop.repository.ProductRepository;
import be.technobel.eshop.repository.UserRepository;
import be.technobel.eshop.service.BaseService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@PreAuthorize("hasAnyAuthority('ADMIN','USER','RESPONSABLE')")
@Service
public class OrderServiceImpl implements BaseService<OrderDto, OrderForm, Long> {

    private final OrderRepository repository;
    private final BaseMapper mapper;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public OrderServiceImpl(OrderRepository repository, BaseMapper mapper, ProductRepository productRepository, UserRepository userRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }


    public List<OrderDto> findOrdersByCustomer(Long idCustomer) {

        List<OrderDto> orders = new ArrayList<>();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();


        repository
                .findOrderByIdCustomer(idCustomer)
                .forEach(order -> {
            OrderDto dto = mapper.toDto(order);
            dto.setCustomer(generateCustomerView(order.getIdCustomer()));
            orders.add(dto); });

        if (orders.isEmpty())
            throw new IllegalArgumentException("Order not found");


        if (!idCustomer.equals(user.getIdUser()) && !checkAuthorities(user))
            throw new IllegalArgumentException("You're not able to see this order");

        return orders;
    }

    @Override
    public List<OrderDto> findAll() {

        List<OrderDto> orders = new ArrayList<>();

        repository
                .findAll()
                .forEach(order -> {
                    OrderDto dto = mapper.toDto(order);
                    dto.setCustomer(generateCustomerView(order.getIdCustomer()));
                    orders.add(dto); });

        return orders;
    }

    @Override
    public OrderDto findOne(Long id) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        OrderDto order =
                repository
                        .findById(id)
                        .map(entity -> {
                            OrderDto newDto = mapper.toDto(entity);
                            newDto.setCustomer(generateCustomerView(entity.getIdCustomer()));
                            return newDto;
                        })
                        .orElseThrow(() -> new IllegalArgumentException("Order not found"));


        if (!user.getIdUser().equals(order.getCustomer().getIdUser()) && !checkAuthorities(user))
            throw new IllegalArgumentException("You're not able to see this order");
        return order;
    }

    @Override
    @PreAuthorize("hasAnyAuthority('ADMIN','RESPONSABLE')")
    public boolean save(OrderForm form) {

        Order order = mapper.fromFormToEntity(form);
        List<Product> products = generateProductList(form.getProductsId());

        order.setProducts(products);
        order.setTotPrice(computeTotalPrice(products));

        repository.save(order);

        return repository.existsById(order.getIdOrder());
    }

    @Override
    @PreAuthorize("hasAnyAuthority('ADMIN','RESPONSABLE')")
    public boolean delete(Long id) {
        Order order = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Order not found"));

        repository.delete(order);

        return !repository.existsById(id);
    }

    @Override
    @PreAuthorize("hasAnyAuthority('ADMIN','RESPONSABLE')")
    public OrderDto update(OrderForm form, Long id) {

        Order order;
        if (repository.existsById(id)) {
            order = mapper.fromFormToEntity(form);
            order.setIdOrder(id);
            order.setProducts(generateProductList(form.getProductsId()));
            order.setTotPrice(computeTotalPrice(order.getProducts()));
        } else throw new IllegalArgumentException("Order not found");
        return mapper.toDto(repository.save(order));
    }

    private Float computeTotalPrice(List<Product> products) {

        return products.stream()
                .map(Product::getPrice)
                .reduce(0F, Float::sum);
    }

    private List<Product> generateProductList(List<Long> ids) {

        return ids.stream().map(id ->
                productRepository
                        .findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("Product not found"))
        ).collect(Collectors.toList());
    }

    private UserView generateCustomerView(Long customerId) {

        User user = userRepository.findById(customerId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        UserView view = new UserView();
        view.setAddress(user.getAddress())
                .setDeliveryAddress(user.getDeliveryAddress())
                .setEmail(user.getEmail())
                .setIdUser(user.getIdUser())
                .setUsername(user.getUsername());

        return view;
    }

    private boolean checkAuthorities(User user) {

        return user.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))
                || user.getAuthorities().contains(new SimpleGrantedAuthority("RESPONSABLE"));
    }
}
