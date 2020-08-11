package ru.vote.testtask.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.vote.testtask.model.Meal;
import ru.vote.testtask.model.Restaurant;
import ru.vote.testtask.service.MealService;
import ru.vote.testtask.service.RestaurantService;

import java.util.List;

public abstract class AbstractMealController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MealService mealService;

    @Autowired
    private RestaurantService restaurantService;

    public Restaurant getRestaurant(int restaurantId) {
        log.info("get restaurant {} of current meals", restaurantId);
        return restaurantService.get(restaurantId);
    }

    public List<Meal> getAll(int restaurantId) {
        log.info("get all meals of restaurant {}", restaurantId);
        return mealService.getAll(restaurantId);
    }

    public Meal get(int restaurantId, int mealId) {
        log.info("get meal {} from restaurant {}", mealId, restaurantId);
        return mealService.get(restaurantId, mealId);
    }

    public void delete(int id) {
        log.info("delete restaurant {}", id);
        mealService.delete(id);
    }

    public Meal create(int restaurantId, Meal meal) {
        log.info("Create {}", meal);
        return mealService.create(restaurantId, meal);
    }

    public Meal update(int restaurantId, Meal meal) {
        log.info("Update {}", meal);
        return mealService.update(restaurantId, meal);
    }

}
