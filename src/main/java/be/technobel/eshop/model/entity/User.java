package be.technobel.eshop.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "eshop_user")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUser;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "user_email")
    String email;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();

    @Column(name = "account_non_expired")
    private boolean isAccountNonExpired;

    @Column(name = "account_non_locked")
    private boolean isAccountNonLocked;

    @Column(name = "credentials_non_expired")
    private boolean isCredentialsNonExpired;

    @Column(name = "enabled")
    private boolean isEnabled;

    @Column(name="address")
    private String address;

    @Column(name="delivery_address")
    private String deliveryAddress;

    @Column(name = "created_at")
    @CreationTimestamp
    private Instant creationDate;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Instant updateDate;

    public Long getIdUser() {
        return idUser;
    }

    public User setIdUser(Long idUser) {
        this.idUser = idUser;
        return this;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public User setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public User setDeliveryAddress(String delivery_address) {
        this.deliveryAddress = delivery_address;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public List<String> getRoles() {
        return roles;
    }

    public User setRoles(List<String> roles) {
        this.roles = roles;
        return this;
    }

    public User setAccountNonExpired(boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
        return this;
    }

    public User setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
        return this;
    }

    public User setCredentialsNonExpired(boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
        return this;
    }

    public User setEnabled(boolean enabled) {
        isEnabled = enabled;
        return this;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public User setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public Instant getUpdateDate() {
        return updateDate;
    }

    public User setUpdateDate(Instant updateDate) {
        this.updateDate = updateDate;
        return this;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles
                .stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
