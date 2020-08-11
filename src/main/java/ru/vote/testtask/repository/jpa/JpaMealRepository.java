package ru.vote.testtask.repository.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.vote.testtask.model.Meal;
import ru.vote.testtask.model.Restaurant;
import ru.vote.testtask.repository.MealRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaMealRepository implements MealRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Meal> getAll(int restaurantId) {
        return em.createNamedQuery(Meal.ALL_SORTED, Meal.class).
                setParameter("restaurantId", restaurantId).
                getResultList();
    }

    @Override
    @Transactional
    public boolean delete(int mealId) {
        return em.createNamedQuery(Meal.DELETE)
                .setParameter("id", mealId)
                .executeUpdate() != 0;
    }

    @Override
    public Meal get(int restaurantId, int mealId) {
        Meal meal = em.find(Meal.class, mealId);
        return meal != null && meal.getRestaurant().getId() == restaurantId ? meal : null;
    }

    @Override
    @Transactional
    public Meal save(int restaurantId, Meal meal) {
        meal.setRestaurant(em.getReference(Restaurant.class, restaurantId));
        if (meal.isNew()) {
            em.persist(meal);
            return meal;
        } else if (get(meal.id(), restaurantId) == null) {
            return null;
        }
        return em.merge(meal);
    }
}
