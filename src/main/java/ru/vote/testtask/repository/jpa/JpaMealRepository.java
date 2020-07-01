package ru.vote.testtask.repository.jpa;

import ru.vote.testtask.model.Meal;
import ru.vote.testtask.repository.MealRepository;

import java.util.List;

public class JpaMealRepository implements MealRepository {


    @Override
    public List<Meal> getAll(int restaurantId) {
        return JpaRestaurantRepository.restaurantMap.get(restaurantId).getMealList();
    }

    @Override
    public void delete(int restaurantId, int mealId) {
        JpaRestaurantRepository.restaurantMap.get(restaurantId).getMealList().remove(mealId);
    }

    @Override
    public Meal get(int restaurantId, int mealId) {
        return JpaRestaurantRepository.restaurantMap.get(restaurantId).getMealList().get(mealId);
    }

    @Override
    public Meal create(int restaurantId, Meal meal) {

        if(meal.isNew()) {
            meal.setId(JpaRestaurantRepository.restaurantMap.get(restaurantId).getMealList().size());
            JpaRestaurantRepository.restaurantMap.get(restaurantId).getMealList().add(meal);
        } else {
            JpaRestaurantRepository.restaurantMap.get(restaurantId).getMealList().add(meal.getId(), meal);
        }
        return meal;
    }

    @Override
    public Meal update(int restaurantId, Meal meal) {
        JpaRestaurantRepository.restaurantMap.get(restaurantId).getMealList().add(meal.getId(), meal);
        return meal;
    }
}
