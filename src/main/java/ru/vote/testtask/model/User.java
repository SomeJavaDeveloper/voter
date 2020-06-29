package ru.vote.testtask.model;

import java.util.Date;
import java.util.Set;

public class User extends AbstractEntity{

    private String password;

    private String email;

    private boolean enabled = true;

    private Date registered = new Date();

    private Set<Role> roles;

    private Integer restaurantId;

    public User() {
    }

    public User(String name, String password, String email, boolean enabled, Date registered, Set<Role> roles) {
        this(null, name, password, email, enabled, registered, roles);
    }

    public User(Integer id, String name, String password, String email, boolean enabled, Date registered, Set<Role> roles) {
        super(id, name);
        this.password = password;
        this.email = email;
        this.enabled = enabled;
        this.registered = registered;
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    @Override
    public String toString() {
        return "User{" +
                "password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", enabled=" + enabled +
                ", registered=" + registered +
                ", roles=" + roles +
                ", restaurantId=" + restaurantId +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
