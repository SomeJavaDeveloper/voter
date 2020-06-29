package ru.vote.testtask.model;

import java.util.List;

public class Restaurant extends AbstractEntity {

    private List<Meal> mealList;

    private String description;

    public Restaurant() {
    }

    public Restaurant(String name, List<Meal> mealList, String description) {
        this(null, name, mealList, description);
    }

    public Restaurant(Integer id, String name, List<Meal> mealList, String description) {
        super(id, name);
        this.mealList = mealList;
        this.description = description;
    }

    public List<Meal> getMealList() {
        return mealList;
    }

    public void setMealList(List<Meal> mealList) {
        this.mealList = mealList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "mealList=" + mealList +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
