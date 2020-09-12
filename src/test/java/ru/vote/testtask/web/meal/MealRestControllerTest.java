package ru.vote.testtask.web.meal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.vote.testtask.model.Meal;
import ru.vote.testtask.service.MealService;
import ru.vote.testtask.web.AbstractControllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static ru.vote.testtask.MealTestData.*;

class MealRestControllerTest extends AbstractControllerTest {

    private static final String REST_URL = "/rest/restaurants/100000/meals/";

    @Autowired
    private MealService service;

//    @Test
//    void getAll() throws Exception {
//        MvcResult result = mockMvc
//                .perform(MockMvcRequestBuilders.get(REST_URL)
//                        .accept(MediaType.APPLICATION_JSON_VALUE))
//                .andReturn();
//        assertEquals(200, result.getResponse().getStatus());
//        String mealsJson = result.getResponse().getContentAsString();
//        assertEquals(mealsJson, objectToJson(RESTAURANT1_MEALS));
//    }

    @Test
    void get() throws Exception{
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get(REST_URL+MEAL1.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();
        assertEquals(200, result.getResponse().getStatus());
        String mealJson = result.getResponse().getContentAsString();
        assertEquals(mealJson, objectToJson(MEAL1));
    }

    @Test
    void delete() throws Exception {
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.delete(REST_URL+MEAL1.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();
        assertEquals(204, result.getResponse().getStatus());
        Meal m = service.get(100000, MEAL1.getId());
        assertNull(service.get(100000, MEAL1.getId()));
    }

    @Test
    void createMeal() throws Exception{
        Meal meal = getNew();
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.post(REST_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectToJson(meal)))
                .andReturn();
        assertEquals(201, result.getResponse().getStatus());
        String mealJson = result.getResponse().getContentAsString();
        meal.setId(100006);
        assertEquals(objectToJson(meal), mealJson);
    }

    @Test
    void update() throws Exception{
        Meal meal = getUpdated();
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.put(REST_URL+MEAL1.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectToJson(meal)))
                .andReturn();
        assertEquals(204, result.getResponse().getStatus());
        assertEquals(getUpdated(), service.get(100000, 100002));
    }
}