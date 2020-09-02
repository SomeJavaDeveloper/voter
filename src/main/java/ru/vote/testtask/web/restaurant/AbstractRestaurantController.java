package ru.vote.testtask.web.restaurant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.vote.testtask.model.Restaurant;
import ru.vote.testtask.service.RestaurantService;
import ru.vote.testtask.service.UserService;
import ru.vote.testtask.to.RestaurantTo;
import ru.vote.testtask.util.RestaurantUtil;

import java.util.List;

public abstract class AbstractRestaurantController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private UserService userService;

    public Restaurant get(int id) {
        log.info("get restaurant {}", id);
        return restaurantService.get(id);
    }

    public List<RestaurantTo> getAll() {
        log.info("get all restaurants TO");
        return RestaurantUtil.getTos(restaurantService.getAll());
    }

    public void delete(int id) {
        log.info("delete restaurant {}", id);
        restaurantService.delete(id);
    }

    public Restaurant create(Restaurant restaurant) {
        log.info("Create {}", restaurant);
        return restaurantService.create(restaurant);
    }

    public void update(Restaurant restaurant) {
        log.info("update {}", restaurant);
        restaurantService.update(restaurant);
    }

    public void vote(int userId, int restaurantId) {
        log.info("User " + userId + " voted for " + restaurantId);
        userService.vote(userId, restaurantId);
    }

}

