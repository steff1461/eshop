package be.technobel.eshop.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long idUser;
    private String username;
    private String password;
    private String email;
    private  List<String> roles = new ArrayList<>();
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;
    private String address;
    private String deliveryAddress;
    private Instant creationDate;
    private Instant updateDate;


    public Long getIdUser() {
        return idUser;
    }

    public UserDto setIdUser(Long idUser) {
        this.idUser = idUser;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public List<String> getRoles() {
        return roles;
    }

    public UserDto setRoles(List<String> roles) {
        this.roles = roles;
        return this;
    }

    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    public UserDto setAccountNonExpired(boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
        return this;
    }

    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    public UserDto setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
        return this;
    }

    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    public UserDto setCredentialsNonExpired(boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
        return this;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public UserDto setEnabled(boolean enabled) {
        isEnabled = enabled;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserDto setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public UserDto setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
        return this;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public UserDto setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public Instant getUpdateDate() {
        return updateDate;
    }

    public UserDto setUpdateDate(Instant updateDate) {
        this.updateDate = updateDate;
        return this;
    }
}
