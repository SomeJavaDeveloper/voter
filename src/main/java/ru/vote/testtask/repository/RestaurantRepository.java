package ru.vote.testtask.repository;

import ru.vote.testtask.model.Restaurant;

import java.util.List;

public interface RestaurantRepository {

    List<Restaurant> getAll();

    boolean delete(int id);

    Restaurant save(Restaurant restaurant);

    Restaurant get(int id);
}
