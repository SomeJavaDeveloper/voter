package ru.vote.testtask.to;

import ru.vote.testtask.model.Meal;

import java.util.List;
//remove all TO
public class RestaurantTo {

    private final Integer id;

    private final String name;

    private final String description;

    private List<Meal> meals;

    public RestaurantTo(Integer id, String name, String description, List<Meal> meals) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.meals = meals;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Meal> getMeals() {
        return meals;
    }


    @Override
    public String toString() {
        return "RestaurantTo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", meals=" + meals +
                '}';
    }
}
