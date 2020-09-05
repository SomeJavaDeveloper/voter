package ru.vote.testtask.repository;

import ru.vote.testtask.model.Meal;

import java.util.List;

public interface MealRepository {

    List<Meal> getAll(int restaurantId);

    boolean delete(int mealId);

    Meal get(int restaurantId, int mealId);

    Meal save(int restaurantId, Meal meal);

}
