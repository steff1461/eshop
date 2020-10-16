package be.technobel.eshop.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "eshop_product")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProduct;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_weight")
    private Float weight;

    @Column(name = "product_price")
    private Float price;

    @ManyToOne
    @JoinColumn(name = "product_category")
    private Category category;

    @Column(name = "created_at")
    @CreationTimestamp
    private Instant creationDate;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Instant updateDate;


    public Long getIdProduct() {
        return idProduct;
    }

    public Product setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public Float getWeight() {
        return weight;
    }

    public Product setWeight(Float weight) {
        this.weight = weight;
        return this;
    }

    public Float getPrice() {
        return price;
    }

    public Product setPrice(Float price) {
        this.price = price;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Product setCategory(Category category) {
        this.category = category;
        return this;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public Product setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public Instant getUpdateDate() {
        return updateDate;
    }

    public Product setUpdateDate(Instant updateDate) {
        this.updateDate = updateDate;
        return this;
    }
}
