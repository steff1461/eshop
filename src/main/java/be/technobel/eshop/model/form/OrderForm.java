package be.technobel.eshop.model.form;

import be.technobel.eshop.model.enumeration.EPaymentMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderForm {

    private EPaymentMode paymentMode;
    private Long idCustomer;
    private List<Long> productsId;
    private LocalDate deliveryDate;

    public EPaymentMode getPaymentMode() {
        return paymentMode;
    }

    public OrderForm setPaymentMode(EPaymentMode paymentMode) {
        this.paymentMode = paymentMode;
        return this;
    }

    public Long getIdCustomer() {
        return idCustomer;
    }

    public OrderForm setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
        return this;
    }

    public List<Long> getProductsId() {
        return productsId;
    }

    public OrderForm setProductsId(List<Long> productsId) {
        this.productsId = productsId;
        return this;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public OrderForm setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
        return this;
    }
}
