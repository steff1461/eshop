package be.technobel.eshop.model.simpleview;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserView {

    private Long idUser;
    private String username;
    private String password;
    private String email;
    private String address;
    private String deliveryAddress;

    public Long getIdUser() {
        return idUser;
    }

    public UserView setIdUser(Long idUser) {
        this.idUser = idUser;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserView setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserView setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserView setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserView setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public UserView setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
        return this;
    }
}
