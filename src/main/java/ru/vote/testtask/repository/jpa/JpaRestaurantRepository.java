package ru.vote.testtask.repository.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.vote.testtask.model.Restaurant;
import ru.vote.testtask.repository.RestaurantRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Repository
@Transactional(readOnly = true)
public class JpaRestaurantRepository implements RestaurantRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Restaurant> getAll() {
        List<Restaurant> restaurants = em.createNamedQuery(Restaurant.ALL_SORTED, Restaurant.class).getResultList();
        return restaurants;
//        return em.createQuery("SELECT r FROM " + Restaurant.class.getName() + " r", Restaurant.class).getResultList();
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        return em.createNamedQuery(Restaurant.DELETE)
                .setParameter("id", id)
                .executeUpdate() != 0;
    }

    @Override
    @Transactional
    public Restaurant save(Restaurant restaurant) {
        if(restaurant.getId() == null) {
            em.persist(restaurant);
            return restaurant;
        } else {
            return em.merge(restaurant);
        }
    }


    @Override
    public Restaurant get(int id) {
        return em.find(Restaurant.class, id);
    }


}
