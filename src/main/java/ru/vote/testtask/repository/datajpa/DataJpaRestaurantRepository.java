package ru.vote.testtask.repository.datajpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.vote.testtask.model.Restaurant;
import ru.vote.testtask.repository.RestaurantRepository;

import java.util.List;

@Repository
public class DataJpaRestaurantRepository implements RestaurantRepository {

    private final CrudRestaurantRepository repository;

    public DataJpaRestaurantRepository(CrudRestaurantRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Restaurant> getAll() {
        return repository.getAll();
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id) != 0;
    }

//    @Override
//    @Transactional
//    public Meal save(Meal meal, int userId) {
//        if (!meal.isNew() && get(meal.getId(), userId) == null) {
//            return null;
//        }
//        meal.setUser(crudUserRepository.getOne(userId));
//        return crudMealRepository.save(meal);
//    }

    @Override
    @Transactional
    public Restaurant save(Restaurant restaurant) {
        return repository.save(restaurant);
    }

//    @Override
//    public Meal get(int id, int userId) {
//        return crudMealRepository.findById(id)
//                .filter(meal -> meal.getUser().getId() == userId)
//                .orElse(null);
//    }

    @Override
    public Restaurant get(int id) {
        return repository.findById(id)
                .orElse(null);
    }
}
