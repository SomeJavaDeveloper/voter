package ru.vote.testtask.web;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.util.NestedServletException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.vote.testtask.TestUtil.userAuth;
import static ru.vote.testtask.UserTestData.USER;

class RootControllerTest extends AbstractControllerTest {

    @Test
    void getRestaurants() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/restaurants")
                    .with(userAuth(USER)))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/jsp/restaurants.jsp"))
                .andReturn();
    }

//    @Test
//    void getUsers() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/users")
//                    .with(userAuth(ADMIN)))
//                .andExpect(status().isOk())
//                .andExpect(forwardedUrl("/WEB-INF/jsp/users.jsp"))
//                .andReturn();
//    }

    @Test
    void unAuth() {
        assertThrows(NestedServletException.class, ()
                -> mockMvc.perform(MockMvcRequestBuilders.get("/users")).andExpect(status().is3xxRedirection()));
    }
}
