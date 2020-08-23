package ru.vote.testtask.web.restaurant;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.vote.testtask.model.Restaurant;
import ru.vote.testtask.service.RestaurantService;
import ru.vote.testtask.util.exception.NotFoundException;
import ru.vote.testtask.web.AbstractControllerTest;

import static org.junit.jupiter.api.Assertions.*;
import static ru.vote.testtask.RestaurantTestData.*;

class RestaurantRestControllerTest extends AbstractControllerTest {

    private static final String REST_URL = RestaurantRestController.REST_URL + '/';

    @Autowired
    private RestaurantService service;

//    @Test
//    void getAll() throws Exception {
//        MvcResult result = mockMvc
//                .perform(MockMvcRequestBuilders.get(REST_URL)
//                        .accept(MediaType.APPLICATION_JSON_VALUE))
//                .andReturn();
//        assertEquals(200, result.getResponse().getStatus());
//        String restaurantsJson = result.getResponse().getContentAsString();
//        assertEquals(restaurantsJson, objectToJson(RESTAURANTS_ARRAY));
//    }

    @Test
    void get() throws Exception{
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get(REST_URL+RESTAURANT1.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();
        assertEquals(200, result.getResponse().getStatus());
        String restaurantsJson = result.getResponse().getContentAsString();
        assertEquals(restaurantsJson, objectToJson(RESTAURANT1));
    }

    @Test
    void delete() throws Exception{
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.delete(REST_URL+RESTAURANT1.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();
        assertEquals(204, result.getResponse().getStatus());
        Restaurant r = service.get(RESTAURANT1.getId());
        assertNull(service.get(RESTAURANT1.getId()));
    }

    @Test
    void createRest() throws Exception{
        Restaurant restaurant = getNew();
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectToJson(restaurant)))
                .andReturn();
        assertEquals(201, result.getResponse().getStatus());
        String restaurantJson = result.getResponse().getContentAsString();
        restaurant.setId(100002);
        assertEquals(objectToJson(restaurant), restaurantJson);
    }

    @Test
    void update() throws Exception{
        Restaurant restaurant = getUpdated();
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.put(REST_URL+RESTAURANT1.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectToJson(restaurant)))
                .andReturn();
        assertEquals(204, result.getResponse().getStatus());
        assertEquals(getUpdated(), service.get(100000));
    }
}