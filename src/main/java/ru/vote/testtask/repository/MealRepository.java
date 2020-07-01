package ru.vote.testtask.repository;

import ru.vote.testtask.model.Meal;

import java.util.List;

public interface MealRepository {

    public List<Meal> getAll(int restaurantId);

    public void delete(int restaurantId, int mealId);

    public Meal get(int restaurantId, int mealId);

    public Meal create(int restaurantId, Meal meal);

    public Meal update(int restaurantId, Meal meal);

}
