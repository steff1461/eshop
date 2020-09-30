package be.technobel.eshop.model.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserForm {

    private String username;
    private String password;
    private String email;
    private String address;
    private String deliveryAddress;
    private List<String> roles = new ArrayList<>();

    public String getUsername() {
        return username;
    }

    public UserForm setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserForm setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserForm setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserForm setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public UserForm setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
        return this;
    }

    public List<String> getRoles() {
        return roles;
    }
}
