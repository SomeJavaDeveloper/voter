package ru.vote.testtask.service;

import ru.vote.testtask.model.Restaurant;
import ru.vote.testtask.repository.RestaurantRepository;
import ru.vote.testtask.repository.jpa.JpaRestaurantRepository;
import ru.vote.testtask.to.RestaurantTo;

import java.util.List;

public class RestaurantService {

    private final RestaurantRepository repository = new JpaRestaurantRepository();

//    public RestaurantService(RestaurantRepository repository) {
//        this.repository = repository;
//    }

    public List<Restaurant> getAll(){
        return repository.getAll();
    }

    public void delete(int id){
        repository.delete(id);
    }

    public Restaurant create(Restaurant restaurant){
        return repository.create(restaurant);
    }

    public Restaurant update(Restaurant restaurant){
        return repository.update(restaurant);
    }

    public Restaurant get(int id){
        return repository.get(id);
    }
}
