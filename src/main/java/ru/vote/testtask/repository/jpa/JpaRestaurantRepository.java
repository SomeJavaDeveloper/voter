package ru.vote.testtask.repository.jpa;

import ru.vote.testtask.model.Meal;
import ru.vote.testtask.model.Restaurant;
import ru.vote.testtask.repository.RestaurantRepository;
import ru.vote.testtask.to.RestaurantTo;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class JpaRestaurantRepository implements RestaurantRepository {

//    private List<Restaurant> restaurantList = new ArrayList<>();
//
//    {
//        restaurantList.add(new Restaurant(1, "rest_1", null, "rest_1_desc"));
//        restaurantList.add(new Restaurant(2, "rest_2", null, "rest_2_desc"));
//        restaurantList.add(new Restaurant(3, "rest_3", null, "rest_3_desc"));
//        restaurantList.add(new Restaurant(4, "rest_4", null, "rest_4_desc"));
//    }
    private AtomicInteger currentId = new AtomicInteger(5);

    public static Map<Integer, Restaurant> restaurantMap = new HashMap<>();


    static {
        restaurantMap.put(1, new Restaurant(1, "rest_1", Arrays.asList(
                new Meal(1, "rest_1_meal_1", 10),
                new Meal(2, "rest_1_meal_2", 20)
        ), "rest_1_desc"));
        restaurantMap.put(2, new Restaurant(2, "rest_2", Arrays.asList(
                new Meal(1, "rest_2_meal_1", 30),
                new Meal(2, "rest_2_meal_2", 40)
        ), "rest_2_desc"));
        restaurantMap.put(3, new Restaurant(3, "rest_3", Arrays.asList(
                new Meal(1, "rest_3_meal_1", 50),
                new Meal(2, "rest_3_meal_2", 60)
        ), "rest_3_desc"));
        restaurantMap.put(4, new Restaurant(4, "rest_4", Arrays.asList(
                new Meal(1, "rest_4_meal_1", 70),
                new Meal(2, "rest_4_meal_2", 280)
        ), "rest_4_desc"));
    }

    @Override
    public List<Restaurant> getAll() {
        return new ArrayList<>(restaurantMap.values());
    }

    @Override
    public void delete(int id) {
        restaurantMap.remove(id);
    }

    @Override
    public Restaurant create(Restaurant restaurant) {
        restaurant.setId(currentId.incrementAndGet());
        return restaurantMap.put(restaurant.getId(), restaurant);
    }

    @Override
    public Restaurant update(Restaurant restaurant) {
        return restaurantMap.put(restaurant.getId(), restaurant);
    }

    @Override
    public Restaurant get(int id) {
        return restaurantMap.get(id);
    }

//    public boolean delete(int id){
//
//    }

}
