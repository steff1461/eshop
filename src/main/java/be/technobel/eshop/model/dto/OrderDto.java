package be.technobel.eshop.model.dto;

import be.technobel.eshop.model.enumeration.EPaymentMode;
import be.technobel.eshop.model.simpleview.ProductView;
import be.technobel.eshop.model.simpleview.UserView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {

    private Long idOrder;
    private EPaymentMode paymentMode;
    private Float totPrice;
    private UserView customer;
    private List<ProductView> products;
    private LocalDate deliveryDate;

    public Long getIdOrder() {
        return idOrder;
    }

    public OrderDto setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
        return this;
    }

    public EPaymentMode getPaymentMode() {
        return paymentMode;
    }

    public OrderDto setPaymentMode(EPaymentMode paymentMode) {
        this.paymentMode = paymentMode;
        return this;
    }

    public Float getTotPrice() {
        return totPrice;
    }

    public OrderDto setTotPrice(Float totPrice) {
        this.totPrice = totPrice;
        return this;
    }

    public UserView getCustomer() {
        return customer;
    }

    public OrderDto setCustomer(UserView customer) {
        this.customer = customer;
        return this;
    }

    public List<ProductView> getProducts() {
        return products;
    }

    public OrderDto setProducts(List<ProductView> products) {
        this.products = products;
        return this;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public OrderDto setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
        return this;
    }
}
