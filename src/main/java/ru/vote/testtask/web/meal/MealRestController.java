package ru.vote.testtask.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vote.testtask.model.Meal;
import ru.vote.testtask.repository.jpa.JpaRestaurantRepository;
import ru.vote.testtask.service.MealService;
import ru.vote.testtask.to.MealTo;
import ru.vote.testtask.util.MealUtil;

import java.util.List;

public class MealRestController {

    private static final Logger log = LoggerFactory.getLogger(MealRestController.class);

    private MealService service = new MealService();

    public List<MealTo> getAll(int restaurantId) {
        log.info("get all meals from restaurant with id=" + restaurantId);
        return MealUtil.getTos(service.getAll(restaurantId));
    }

    public void delete(int restaurantId, int mealId){
        log.info("delete " + mealId + " from restaurant with id=" + restaurantId);
        service.delete(restaurantId, mealId);
    }

    public Meal get(int restaurantId, int mealId){
        log.info("get " + mealId + " from restaurant with id=" + restaurantId);
        return service.get(restaurantId, mealId);
    }

    public Meal create(int restaurantId, Meal meal){
        log.info("crete " + meal + " for restaurant with id=" + restaurantId);
        return service.create(restaurantId, meal);
    }

    public Meal update(int restaurantId, Meal meal){
        log.info("update " +meal + " for restaurant with id=" + restaurantId);
        return service.update(restaurantId, meal);
    }
}
