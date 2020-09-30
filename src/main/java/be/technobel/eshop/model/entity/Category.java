package be.technobel.eshop.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Table(name = "eshop_category_product")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCategory;

    @Column(name = "category_name")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<>();

    @Column(name = "created_at")
    @CreationTimestamp
    private Instant creationDate;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Instant updateDate;



    public Long getIdCategory() {
        return idCategory;
    }

    public Category setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
        return this;
    }

    public String getName() {
        return name;
    }

    public Category setName(String name) {
        this.name = name;
        return this;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Category setProducts(List<Product> products) {
        this.products = products;
        return this;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public Category setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public Instant getUpdateDate() {
        return updateDate;
    }

    public Category setUpdateDate(Instant updateDate) {
        this.updateDate = updateDate;
        return this;
    }
}
