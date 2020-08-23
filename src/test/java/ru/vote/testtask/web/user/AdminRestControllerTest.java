package ru.vote.testtask.web.user;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.vote.testtask.model.User;
import ru.vote.testtask.service.UserService;
import ru.vote.testtask.web.AbstractControllerTest;

import static org.junit.jupiter.api.Assertions.*;
import static ru.vote.testtask.UserTestData.getNew;
import static ru.vote.testtask.TestUtil.userHttpBasic;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static ru.vote.testtask.UserTestData.*;

public class AdminRestControllerTest extends AbstractControllerTest {

    private static final String REST_URL = AdminRestController.REST_URL + '/';

    @Autowired
    private UserService service;

    //JSON --> Array/Object

    @Test
    void getAll() throws Exception {
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get(REST_URL)
                        .with(userHttpBasic(ADMIN)))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();
        assertEquals(200, result.getResponse().getStatus());
        String restaurantsJson = result.getResponse().getContentAsString();

        User u = USER;

        assertEquals(restaurantsJson, objectToJson(USERS_ARRAY));
    }

    @Test
    void get() throws Exception{
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get(REST_URL+USER.getId())
                        .with(userHttpBasic(ADMIN)))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();
        assertEquals(200, result.getResponse().getStatus());
        String restaurantsJson = result.getResponse().getContentAsString();
        assertEquals(restaurantsJson, objectToJson(USER));
    }

    @Test
    void delete() throws Exception{
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.delete(REST_URL+USER.getId())
                        .with(userHttpBasic(ADMIN)))
                .andReturn();
        assertEquals(204, result.getResponse().getStatus());
        User u = service.get(USER.getId());
        assertNull(service.get(USER.getId()));
    }

    @Test
    void createRest() throws Exception{
        User user = getNew();
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.post(REST_URL)
                        .with(userHttpBasic(ADMIN))
                        .content(objectToJson(user)))
                .andReturn();
        assertEquals(201, result.getResponse().getStatus());
        String userJson = result.getResponse().getContentAsString();
        user.setId(100000);
        assertEquals(objectToJson(user), userJson);
    }

    @Test
    void update() throws Exception{
        User user = getUpdated();
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.put(REST_URL+USER.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .with(userHttpBasic(ADMIN))
                        .content(objectToJson(user)))
                .andReturn();
        assertEquals(204, result.getResponse().getStatus());
        assertEquals(getUpdated(), service.get(100000));
    }
}
