package ru.vote.testtask.service.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.vote.testtask.model.User;
import ru.vote.testtask.service.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.vote.testtask.UserTestData.*;

@SpringJUnitConfig(locations = {
        "classpath:spring/spring-app.xml",
})
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class JpaUserServiceTest {

    @Autowired
    private UserService service;

    @Test
    void create() {
        User created = service.create(getNew());
        int newId = created.getId();
        User newUser= getNew();
        newUser.setId(newId);
        assertEquals(created, newUser);
        assertEquals(service.get(newId), newUser);

    }

    @Test
    void get() {
        User actual = service.get(USER.getId());
        assertEquals(actual, USER);
    }

    @Test
    void getByEmail() {
        User actual = service.getByEmail(USER.getEmail());
        assertEquals(actual, USER);
    }

    @Test
    void getAll() {
        assertEquals(service.getAll(), USERS);
    }

    @Test
    void vote() {
        USER.setRestaurantId(100000);
        assertEquals(USER.getRestaurantId(), 100000);
    }
}