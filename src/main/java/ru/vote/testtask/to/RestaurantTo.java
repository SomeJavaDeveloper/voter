package ru.vote.testtask.to;

import ru.vote.testtask.model.Meal;

import java.util.List;

public class RestaurantTo {

    private final Integer id;

    private final String name;

    private final List<Meal> mealList;

    private final String description;

    public RestaurantTo(Integer id, String name, List<Meal> mealList, String description) {
        this.id = id;
        this.name = name;
        this.mealList = mealList;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Meal> getMealList() {
        return mealList;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "RestaurantTo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mealList=" + mealList +
                ", description='" + description + '\'' +
                '}';
    }
}
