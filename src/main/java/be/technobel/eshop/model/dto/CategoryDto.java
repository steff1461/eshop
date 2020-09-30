package be.technobel.eshop.model.dto;

import be.technobel.eshop.model.simpleview.ProductView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {


    private Long idCategory;
    private String name;
    private List<ProductView> products = new ArrayList<>();

    public Long getIdCategory() {
        return idCategory;
    }

    public CategoryDto setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
        return this;
    }

    public String getName() {
        return name;
    }

    public CategoryDto setName(String name) {
        this.name = name;
        return this;
    }

    public List<ProductView> getProducts() {
        return products;
    }

    public CategoryDto setProducts(List<ProductView> products) {
        this.products = products;
        return this;
    }
}
