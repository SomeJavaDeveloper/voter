package ru.vote.testtask.repository;

import ru.vote.testtask.model.Restaurant;

import java.util.List;

public interface RestaurantRepository {

    public List<Restaurant> getAll();

//    public boolean delete(int id);

    public boolean delete(int id);

    public Restaurant save(Restaurant restaurant);

    public Restaurant get(int id);
}
