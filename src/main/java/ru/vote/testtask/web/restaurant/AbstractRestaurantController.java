package ru.vote.testtask.web.restaurant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.vote.testtask.model.Restaurant;
import ru.vote.testtask.service.RestaurantService;

import java.util.List;

public abstract class AbstractRestaurantController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestaurantService service;

    public Restaurant get(int id) {
        log.info("get restaurant {}", id);
        return service.get(id);
    }

    public List<Restaurant> getAll() {
        log.info("get all restaurants");
        return service.getAll();
    }

    public void delete(int id) {
        log.info("delete restaurant {}", id);
        service.delete(id);
    }

    public Restaurant create(Restaurant restaurant) {
        log.info("Create {}", restaurant);
        return service.create(restaurant);
    }

    public Restaurant update(Restaurant restaurant) {
        log.info("update {}", restaurant);
        return service.update(restaurant);
    }


}

