package ru.vote.testtask.to;

import ru.vote.testtask.model.Meal;

import java.util.List;

public class RestaurantTo {

    private final Integer id;

    private final String name;

    private final String description;

    public RestaurantTo(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    @Override
    public String toString() {
        return "RestaurantTo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
