package be.technobel.eshop.model.dto;

import be.technobel.eshop.model.simpleview.CategoryView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

    private Long idProduct;
    private String name;
    private Float weight;
    private Float price;
    private CategoryView category;

    public Long getIdProduct() {
        return idProduct;
    }

    public ProductDto setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductDto setName(String name) {
        this.name = name;
        return this;
    }

    public Float getWeight() {
        return weight;
    }

    public ProductDto setWeight(Float weight) {
        this.weight = weight;
        return this;
    }

    public Float getPrice() {
        return price;
    }

    public ProductDto setPrice(Float price) {
        this.price = price;
        return this;
    }

    public CategoryView getCategory() {
        return category;
    }

    public ProductDto setCategory(CategoryView category) {
        this.category = category;
        return this;
    }
}
