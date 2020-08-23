package ru.vote.testtask.web.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.vote.testtask.model.User;
import ru.vote.testtask.service.UserService;
import ru.vote.testtask.to.UserTo;
import ru.vote.testtask.util.UserUtil;
import ru.vote.testtask.web.AbstractControllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static ru.vote.testtask.RestaurantTestData.RESTAURANT1;
import static ru.vote.testtask.TestUtil.userHttpBasic;
import static ru.vote.testtask.UserTestData.*;
import static ru.vote.testtask.web.user.ProfileRestController.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

public class ProfileRestControllerTest extends AbstractControllerTest {

    @Autowired
    private UserService userService;

    @Test
    void get() throws Exception {
//        perform(MockMvcRequestBuilders.get(REST_URL)
//                .with(userHttpBasic(USER)))
//                .andExpect(status().isOk())
//                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//                .andExpect(USER_MATCHER.contentJson(USER));

        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get(REST_URL)
                        .with(userHttpBasic(ADMIN)))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();
        assertEquals(200, result.getResponse().getStatus());
        String restaurantsJson = result.getResponse().getContentAsString();
        assertEquals(restaurantsJson, objectToJson(USER));
    }

    @Test
    void getUnAuth() throws Exception {
//        perform(MockMvcRequestBuilders.get(REST_URL))
//                .andExpect(status().isUnauthorized());

        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get(REST_URL))
                .andReturn();
        assertEquals(314, result.getResponse().getStatus());
    }

    @Test
    void delete() throws Exception {
//        perform(MockMvcRequestBuilders.delete(REST_URL)
//                .with(userHttpBasic(USER)))
//                .andExpect(status().isNoContent());
//        USER_MATCHER.assertMatch(userService.getAll(), ADMIN);

        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.delete(REST_URL)
                        .with(userHttpBasic(USER)))
                .andReturn();
        assertEquals(400, result.getResponse().getStatus());
        assertNull(userService.get(USER.getId()));
    }

    @Test
    void register() throws Exception {
        UserTo newTo = new UserTo(null, "newName", "newemail@ya.ru", "newPassword");
        User newUser = UserUtil.createNewFromTo(newTo);
//        ResultActions action = perform(MockMvcRequestBuilders.post(REST_URL + "/register")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(JsonUtil.writeValue(newTo)))
//                .andDo(print())
//                .andExpect(status().isCreated());
//
//        User created = readFromJson(action, User.class);
//        int newId = created.getId();
//        newUser.setId(newId);
//        USER_MATCHER.assertMatch(created, newUser);
//        USER_MATCHER.assertMatch(userService.get(newId), newUser);
    }

    @Test
    void update() throws Exception {
//        UserTo updatedTo = new UserTo(null, "newName", "newemail@ya.ru", "newPassword");
//        perform(MockMvcRequestBuilders.put(REST_URL).contentType(MediaType.APPLICATION_JSON)
//                .with(userHttpBasic(USER))
//                .content(JsonUtil.writeValue(updatedTo)))
//                .andDo(print())
//                .andExpect(status().isNoContent());

//        USER_MATCHER.assertMatch(userService.get(USER_ID), UserUtil.updateFromTo(new User(USER), updatedTo));
    }


//    @Test
//    void updateInvalid() throws Exception {
//        UserTo updatedTo = new UserTo(null, null, "password", null, 1500);
//        perform(MockMvcRequestBuilders.put(REST_URL)
//                .contentType(MediaType.APPLICATION_JSON)
//                .with(userHttpBasic(USER))
//                .content(JsonUtil.writeValue(updatedTo)))
//                .andDo(print())
//                .andExpect(status().isUnprocessableEntity())
//                .andExpect(errorType(VALIDATION_ERROR));
//    }
//
//    @Test
//    @Transactional(propagation = Propagation.NEVER)
//    void updateDuplicate() throws Exception {
//        UserTo updatedTo = new UserTo(null, "newName", "admin@gmail.com", "newPassword", 1500);
//        perform(MockMvcRequestBuilders.put(REST_URL).contentType(MediaType.APPLICATION_JSON)
//                .with(userHttpBasic(USER))
//                .content(JsonUtil.writeValue(updatedTo)))
//                .andDo(print())
//                .andExpect(status().isUnprocessableEntity())
//                .andExpect(errorType(VALIDATION_ERROR))
//                .andExpect(detailMessage(EXCEPTION_DUPLICATE_EMAIL));
//    }
}
