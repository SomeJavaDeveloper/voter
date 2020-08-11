package ru.vote.testtask.repository.datajpa;

import org.springframework.stereotype.Repository;
import ru.vote.testtask.model.Meal;
import ru.vote.testtask.repository.MealRepository;

import java.util.List;

@Repository
public class DataJpaMealRepository implements MealRepository {

    private final CrudMealRepository mealRepository;
    private final CrudRestaurantRepository restaurantRepository;

    public DataJpaMealRepository(CrudMealRepository mealRepository, CrudRestaurantRepository restaurantRepository) {
        this.mealRepository = mealRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Meal> getAll(int restaurantId) {
        return mealRepository.getAll(restaurantId);
    }

    @Override
    public boolean delete(int mealId) {
        return mealRepository.delete(mealId) != 0;
    }

    @Override
    public Meal get(int restaurantId, int mealId) {
        Meal meal = mealRepository.findById(mealId).orElse(null);
        return meal != null && meal.getRestaurant().getId() != restaurantId ? meal : null;
    }

    @Override
    public Meal save(int restaurantId, Meal meal) {
        meal.setRestaurant(restaurantRepository.getOne(restaurantId));
        return mealRepository.save(meal);
    }
}
