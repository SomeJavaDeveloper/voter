package ru.vote.testtask.service;

import org.springframework.stereotype.Service;
import ru.vote.testtask.model.Restaurant;
import ru.vote.testtask.repository.RestaurantRepository;

import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository repository;

    public RestaurantService(RestaurantRepository repository) {
        this.repository = repository;
    }

    public List<Restaurant> getAll(){
        return repository.getAll();
    }

    public void delete(int id){
        repository.delete(id);
    }

    public Restaurant create(Restaurant restaurant){
        return repository.save(restaurant);
    }

    public Restaurant update(Restaurant restaurant){
        return repository.save(restaurant);
    }

    public Restaurant get(int id){
        return repository.get(id);
    }
}
