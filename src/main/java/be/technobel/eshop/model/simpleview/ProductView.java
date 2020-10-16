package be.technobel.eshop.model.simpleview;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductView {


    private String name;
    private Float weight;
    private Float price;
    private Long idProduct;


    public String getName() {
        return name;
    }

    public ProductView setName(String name) {
        this.name = name;
        return this;
    }

    public Float getWeight() {
        return weight;
    }

    public ProductView setWeight(Float weight) {
        this.weight = weight;
        return this;
    }

    public Float getPrice() {
        return price;
    }

    public ProductView setPrice(Float price) {
        this.price = price;
        return this;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public ProductView setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
        return this;
    }
}
