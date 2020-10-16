package be.technobel.eshop.mapper;

import be.technobel.eshop.model.dto.CategoryDto;
import be.technobel.eshop.model.dto.OrderDto;
import be.technobel.eshop.model.dto.ProductDto;
import be.technobel.eshop.model.dto.UserDto;
import be.technobel.eshop.model.entity.*;
import be.technobel.eshop.model.form.CategoryForm;
import be.technobel.eshop.model.form.OrderForm;
import be.technobel.eshop.model.form.ProductForm;
import be.technobel.eshop.model.form.UserForm;
import be.technobel.eshop.model.simpleview.CategoryView;
import be.technobel.eshop.model.simpleview.ProductView;
import org.aspectj.apache.bcel.generic.TABLESWITCH;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.List;

@Mapper()
public interface BaseMapper {


    //Users

    @Mappings({

            @Mapping(target = "isAccountNonExpired", source = "accountNonExpired"),
            @Mapping(target = "isAccountNonLocked", source = "accountNonLocked"),
            @Mapping(target = "isCredentialsNonExpired", source = "credentialsNonExpired"),
            @Mapping(target = "isEnabled", source = "enabled"),
            @Mapping(target = "roles", source = "roles")
    })
    UserDto toDto(User user);

    @Mappings({

            @Mapping(target = "idUser", ignore = true),
            @Mapping(target = "isAccountNonExpired", ignore = true),
            @Mapping(target = "isAccountNonLocked", ignore = true),
            @Mapping(target = "isCredentialsNonExpired", ignore = true),
            @Mapping(target = "isEnabled", ignore = true),
            @Mapping(target = "creationDate", ignore = true),
            @Mapping(target = "updateDate", ignore = true),
            //@Mapping(target = "authorities", ignore = true)
    })
    User fromFormtoEntity(UserForm form);


    //Category

    @Mappings({
            @Mapping(target = "products",source = "products", qualifiedByName = "fromProductToView" )
    })
    CategoryDto toDto(Category category);

    @Mappings({

            @Mapping(target = "idCategory", ignore = true),
            @Mapping(target = "products", ignore = true),
            @Mapping(target = "creationDate", ignore = true),
            @Mapping(target = "updateDate", ignore = true)
    })
    Category fromFormToEntity(CategoryForm form);


    @Named("fromProductToView")
    default ProductView generateProductView(Product product){

        ProductView view = new ProductView();

        view.setName(product.getName())
                .setPrice(product.getPrice())
                .setWeight(product.getWeight())
                .setIdProduct(product.getIdProduct());

        return view;
    }

    //Product

    @Mappings({

            @Mapping(target = "category", source = "category", qualifiedByName = "fromCategoryToView")
    })
    ProductDto toDto(Product product);

    @Mappings({

            @Mapping(target = "idProduct", ignore = true),
            @Mapping(target = "category", ignore = true),
            @Mapping(target = "creationDate", ignore = true),
            @Mapping(target = "updateDate", ignore = true),
    })
    Product fromFormToEntity(ProductForm form);

    @Named("fromCategoryToView")
    default CategoryView generateCategoryView(Category category){

        CategoryView view = new CategoryView();
        view.setName(category.getName());
        view.setId(category.getIdCategory());
        return view;
    }

    //Order

    @Mappings({

            @Mapping(target = "customer", ignore = true),
            @Mapping(target = "products",source= "products", qualifiedByName = "fromProductToView"),
    })
    OrderDto toDto(Order order);


    @Mappings({

            @Mapping(target="idOrder",ignore = true),
            @Mapping(target = "totPrice",ignore = true),
            @Mapping(target = "products", ignore = true)
    })

    Order fromFormToEntity(OrderForm form);


}
