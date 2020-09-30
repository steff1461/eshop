package be.technobel.eshop.model.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductForm {

    private String name;
    private Float weight;
    private Float price;
    private Long categoryId;

    public String getName() {
        return name;
    }

    public ProductForm setName(String name) {
        this.name = name;
        return this;
    }

    public Float getWeight() {
        return weight;
    }

    public ProductForm setWeight(Float weight) {
        this.weight = weight;
        return this;
    }

    public Float getPrice() {
        return price;
    }

    public ProductForm setPrice(Float price) {
        this.price = price;
        return this;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public ProductForm setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
        return this;
    }
}
