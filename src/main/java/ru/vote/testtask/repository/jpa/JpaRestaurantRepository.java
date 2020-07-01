package ru.vote.testtask.repository.jpa;

import ru.vote.testtask.model.Restaurant;
import ru.vote.testtask.repository.RestaurantRepository;
import ru.vote.testtask.to.RestaurantTo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    private Map<Integer, Restaurant> restaurantMap = new HashMap<>();


    {
        restaurantMap.put(1, new Restaurant(1, "rest_1", null, "rest_1_desc"));
        restaurantMap.put(2, new Restaurant(2, "rest_2", null, "rest_2_desc"));
        restaurantMap.put(3, new Restaurant(3, "rest_3", null, "rest_3_desc"));
        restaurantMap.put(4, new Restaurant(4, "rest_4", null, "rest_4_desc"));
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
