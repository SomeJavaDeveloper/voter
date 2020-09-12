package ru.vote.testtask.web.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.util.NestedServletException;
import ru.vote.testtask.model.User;
import ru.vote.testtask.service.UserService;
import ru.vote.testtask.to.UserTo;
import ru.vote.testtask.util.UserUtil;
import ru.vote.testtask.web.AbstractControllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.vote.testtask.web.user.ProfileRestController.REST_URL;


class ProfileRestControllerTest extends AbstractControllerTest {

    @Autowired
    private UserService service;

    @Test
    void getUnAuth() {
        assertThrows(NestedServletException.class, () -> mockMvc.perform(MockMvcRequestBuilders.get(REST_URL)));
    }


    @Test
    void register() throws Exception {
        UserTo newTo = new UserTo(null, "newName", "newemail@ya.ru", "newPassword");
        User newUser = UserUtil.createNewFromTo(newTo);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(REST_URL + "/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectToJson(newTo)))
                .andReturn();

        newUser.setId(100006);
        newUser.setRegistered(service.get(100006).getRegistered());
        String created = result.getResponse().getContentAsString();
        assertEquals(objectToJson(newUser), created);
    }
}
