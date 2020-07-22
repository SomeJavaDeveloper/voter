package ru.vote.testtask.repository;

import ru.vote.testtask.model.Meal;

import java.util.List;

public interface MealRepository {

    public List<Meal> getAll(int restaurantId);

    public boolean delete(int mealId);

    public Meal get(int restaurantId, int mealId);

    public Meal save(int restaurantId, Meal meal);

}
