package ru.vote.testtask.service.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.vote.testtask.model.Meal;
import ru.vote.testtask.service.MealService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static ru.vote.testtask.MealTestData.*;
import static ru.vote.testtask.RestaurantTestData.RESTAURANT1;

@SpringJUnitConfig(locations = {
        "classpath:spring/spring-app.xml"
})
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class JpaMealServiceTest {

    @Autowired
    private MealService service;

//  Wrong order
//    @Test
//    void getAll() {
//        List<Meal> meals = service.getAll(RESTAURANT1.getId());
//        assertEquals(service.getAll(RESTAURANT1.getId()), RESTAURANT1_MEALS);
//    }

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
        int newId = created.getId();
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