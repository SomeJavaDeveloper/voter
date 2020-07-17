package ru.vote.testtask.model;

import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NamedQueries({
        @NamedQuery(name = Meal.ALL_SORTED, query = "SELECT m FROM Meal m WHERE m.restaurant.id=:restaurantId ORDER BY m.name DESC"),
        @NamedQuery(name = Meal.DELETE, query = "DELETE FROM Meal m WHERE m.id=:id AND m.restaurant.id=:restaurantId"),
})
@Entity
@Table(name = "meals", uniqueConstraints = {@UniqueConstraint(columnNames = {"restaurant_id"}, name = "meals_unique_user_idx")})
public class Meal extends AbstractEntity{
    public static final int START_SEQ = 100000;

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    protected Integer id;

    public static final String ALL_SORTED = "Meal.getAll";
    public static final String DELETE = "Meal.delete";

    @Column(name = "price", nullable = false)
    @NotBlank
    private Integer price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @NotNull
    private Restaurant restaurant;

    public Meal() {
    }

    public Meal(String name, Integer price) {
        this(null, name, price);
    }

    public Meal(Integer id, String name, Integer price) {
        super(name);
        this.id = id;
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "price=" + price +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int id() {
        Assert.notNull(id, "Entity must has id");
        return id;
    }

    public boolean isNew(){
        return id == null;
    }
}
