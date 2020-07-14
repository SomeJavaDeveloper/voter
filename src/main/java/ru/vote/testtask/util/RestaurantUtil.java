package ru.vote.testtask.util;

import org.springframework.beans.factory.annotation.Autowired;
import ru.vote.testtask.model.Restaurant;
import ru.vote.testtask.service.MealService;
import ru.vote.testtask.to.RestaurantTo;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RestaurantUtil {

    /////////////////
    @Autowired
    private static MealService service;

    private RestaurantUtil(){

    }

    public static List<RestaurantTo> getTos(Collection<Restaurant> restaurants){
        return getFilteredTos(restaurants, restaurant -> true);
    }

    public static List<RestaurantTo> getFilteredTos(Collection<Restaurant> restaurants,  Predicate<Restaurant> filter){
        return restaurants.stream().
                filter(filter).
                map(RestaurantUtil::createTo).
                collect(Collectors.toList());
    }

    private static RestaurantTo createTo(Restaurant restaurant){
        return new RestaurantTo(restaurant.getId(), restaurant.getName(), service.getAll(restaurant.getId()), restaurant.getDescription());
    }
}
