package ru.vote.testtask.service.jpa;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.vote.testtask.model.Restaurant;
import ru.vote.testtask.service.RestaurantService;

import static ru.vote.testtask.RestaurantTestData.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(locations = {
        "classpath:spring/spring-app.xml",
})
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
class JpaRestaurantServiceTest {

    @Autowired
    private RestaurantService service;

    @Test
    void getAll() {
        assertEquals(service.getAll(), RESTAURANTS);
    }

    @Test
    void delete() {
        service.delete(RESTAURANT1.getId());
        assertNull(service.get(RESTAURANT1.getId()));
    }

    @Test
    void create() {
        Restaurant created = service.create(getNew());
        int newId = created.id();
        Restaurant newRestaurant = getNew();
        newRestaurant.setId(newId);
        assertEquals(created, newRestaurant);
        assertEquals(service.get(newId), newRestaurant);
    }

    @Test
    void update() {
        Restaurant updated = getUpdated();
        service.update(updated);
        assertEquals(service.get(RESTAURANT1.getId()), getUpdated());
    }

    @Test
    void get() {
        Restaurant actual = service.get(RESTAURANT1.getId());
        assertEquals(actual, RESTAURANT1);
    }
}