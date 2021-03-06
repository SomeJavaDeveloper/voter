package ru.vote.testtask.repository.jpa;

import org.hibernate.jpa.QueryHints;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.vote.testtask.model.User;
import ru.vote.testtask.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalTime;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaUserRepository implements UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public User save(User user) {
        if(user.isNew()) {
            em.persist(user);
            return user;
        } else {
            User updaterUser = get(user.getId());
            updaterUser.setEmail(user.getEmail());
            updaterUser.setName(user.getName());
            return em.merge(updaterUser);
        }
    }

    @Override
    public User get(int id) {
        return em.find(User.class, id);
    }

    @Override
    public User getByEmail(String email) {
        List<User> users = em.createNamedQuery(User.BY_EMAIL, User.class)
                .setParameter(1, email)
                .setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false)
                .getResultList();
        return DataAccessUtils.singleResult(users);
    }

    @Override
    public List<User> getAll() {
        return em.createNamedQuery(User.ALL, User.class).getResultList();
    }

    @Override
    @Transactional
    public void vote(User user, int restaurantId) {
        if(LocalTime.now().compareTo(LocalTime.parse("11:00")) < 0) {
            user.setRestaurantId(restaurantId);
            em.merge(user);
        }
    }
}
