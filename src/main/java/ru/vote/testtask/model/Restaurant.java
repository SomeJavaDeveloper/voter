package ru.vote.testtask.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = Restaurant.DELETE, query = "DELETE FROM Restaurant r WHERE r.id=:id"),
        @NamedQuery(name = Restaurant.ALL_SORTED, query = "SELECT r FROM Restaurant r ORDER BY r.name")
})

@Entity
@Table(name = "restaurants")
public class Restaurant extends AbstractEntity {
    public static final int START_SEQ = 100000;

    @Id
    @SequenceGenerator(name = "restaurant_seq", sequenceName = "restaurant_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurant_seq")
    private Integer id;

    public static final String DELETE = "Restaurant.delete";
    public static final String ALL_SORTED = "Restaurant.getAllSorted";

    @Column(name = "description", nullable = false)
    @NotBlank
    private String description;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "restaurant")
    @JsonManagedReference
    private List<Meal> meals;

    public Restaurant() {
    }

    public Restaurant(String name,  String description) {
        this(null, name, description);
    }

    public Restaurant(Integer id, String name, String description) {
        super(name);
        this.id = id;
        this.description = description;
    }

    public Restaurant(Integer id, String name, String description, List<Meal> meals) {
        super(name);
        this.id = id;
        this.description = description;
        this.meals = meals;
    }

    public String getDescription() {
        return description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int id() {
        Assert.notNull(id, "Entity must has id");
        return id;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }
}
