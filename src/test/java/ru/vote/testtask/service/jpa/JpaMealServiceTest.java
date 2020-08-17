package ru.vote.testtask.service.jpa;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.vote.testtask.model.Meal;
import ru.vote.testtask.model.Restaurant;
import ru.vote.testtask.service.MealService;

import static org.junit.jupiter.api.Assertions.*;
import static ru.vote.testtask.MealTestData.*;
import static ru.vote.testtask.MealTestData.MEAL1;
import static ru.vote.testtask.MealTestData.RESTAURANT1_MEALS;
import static ru.vote.testtask.RestaurantTestData.RESTAURANT1;

@SpringJUnitConfig(locations = {
        "classpath:spring/spring-app.xml"
})
class JpaMealServiceTest {

    @Autowired
    private MealService service;

    @Test
    void getAll() {
        List<Meal> meals = service.getAll(RESTAURANT1.getId());
        assertEquals(service.getAll(RESTAURANT1.getId()), RESTAURANT1_MEALS);
    }

    @Test
    void delete() {
        service.delete(MEAL1.getId());
        assertNull(service.get(RESTAURANT1.getId(), MEAL1.getId()));
    }

    @Test
    void get() {
        Meal actual = service.get(100000, 100002);
        assertEquals(actual, MEAL1);
    }

    @Test
    void create() {
        Meal created = service.create(RESTAURANT1.getId(), getNew());
        int newId = created.id();
        Meal newMeal = getNew();
        newMeal.setId(newId);
        assertEquals(created, newMeal);
        assertEquals(service.get(RESTAURANT1.getId(), newId), newMeal);
    }

    @Test
    void update() {
        Meal updated = getUpdated();
        service.update(RESTAURANT1.getId(), updated);
        assertEquals(service.get(RESTAURANT1.getId(), MEAL1.getId()), getUpdated());
    }
}