package ru.vote.testtask.repository;

import ru.vote.testtask.model.User;

import java.util.List;

public interface UserRepository {

    User save(User user);

    User get(int id);

    User getByEmail(String email);

    List<User> getAll();

    void vote(User user, int restaurantId);
}
