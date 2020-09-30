package be.technobel.eshop.model.entity;


import be.technobel.eshop.model.enumeration.EPaymentMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Table(name="eshop_order")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idOrder;

    @Column(name = "order_payment_mode")
    private EPaymentMode paymentMode;

    @Column(name = "order_price")
    private Float totPrice;

    @Column(name = "order_id_cust")
    private Long idCustomer;

    @OneToMany(cascade = CascadeType.REFRESH)
    private List<Product> products = new ArrayList<>();

    @Column(name = "order_deliv_date")
    private LocalDate deliveryDate;


    public Long getIdOrder() {
        return idOrder;
    }

    public Order setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
        return this;
    }

    public EPaymentMode getPaymentMode() {
        return paymentMode;
    }

    public Order setPaymentMode(EPaymentMode paymentMode) {
        this.paymentMode = paymentMode;
        return this;
    }

    public Float getTotPrice() {
        return totPrice;
    }

    public Order setTotPrice(Float totPrice) {
        this.totPrice = totPrice;
        return this;
    }

    public Long getIdCustomer() {
        return idCustomer;
    }

    public Order setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
        return this;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Order setProducts(List<Product> productList) {
        this.products = productList;
        return this;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public Order setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
        return this;
    }
}

