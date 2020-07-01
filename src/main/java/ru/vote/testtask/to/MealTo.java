package ru.vote.testtask.to;

import ru.vote.testtask.model.Meal;

import java.util.List;

public class MealTo {

    private final Integer id;

    private final String name;

    private final Integer price;

    public MealTo(Integer id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "MealTo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
