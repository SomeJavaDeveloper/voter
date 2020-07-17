package ru.vote.testtask.service;

import org.springframework.stereotype.Service;
import ru.vote.testtask.model.Meal;
import ru.vote.testtask.repository.MealRepository;

import java.util.List;

@Service
public class MealService {

    private final MealRepository repository;

    public MealService(MealRepository repository) {
        this.repository = repository;
    }

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
        return repository.save(restaurantId, meal);
    }

    public Meal update(int restaurantId, Meal meal){
        return repository.save(restaurantId, meal);
    }
}
