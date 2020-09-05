package ru.vote.testtask.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.vote.testtask.service.RestaurantService;
import ru.vote.testtask.service.UserService;
import ru.vote.testtask.util.RestaurantUtil;

@Controller
public class RootController {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String root() {
        return "redirect:restaurants";
    }

    @GetMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAll());
        return "users";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping("/restaurants")
    public String getRestaurants(Model model) {
        model.addAttribute("restaurants",
                RestaurantUtil.getTos(restaurantService.getAll()));
        return "restaurants";
    }
}
