package ru.vote.testtask.service;

import ru.vote.testtask.model.Meal;
import ru.vote.testtask.repository.jpa.JpaMealRepository;
import ru.vote.testtask.repository.jpa.JpaRestaurantRepository;

import java.util.List;

public class MealService {

    private final JpaMealRepository repository = new JpaMealRepository();

    public List<Meal> getAll(int restaurantId) {
        return repository.getAll(restaurantId);
    }

    public void delete(int restaurantId, int mealId){
        repository.delete(restaurantId, mealId);
    }

    public Meal get(int restaurantId, int mealId){
        return repository.get(restaurantId, mealId);
    }

    public Meal create(int restaurantId, Meal meal){
        return repository.create(restaurantId, meal);
    }

    public Meal update(int restaurantId, Meal meal){
        return repository.update(restaurantId, meal);
    }
}