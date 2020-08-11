package ru.vote.testtask.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.vote.testtask.service.RestaurantService;
import ru.vote.testtask.service.UserService;
import ru.vote.testtask.util.RestaurantUtil;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RootController {

    @Autowired
    private UserService userService;

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/")
    public String root(){
        return "index";
    }

    @PostMapping("/users")
    public String setUser(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("userId"));
        SecurityUtil.setAuthUserId(userId);
        return "redirect:restaurants";
    }

    @GetMapping("/restaurants")
    public String getRestaurants(Model model) {
        model.addAttribute("restaurants",
                RestaurantUtil.getTos(restaurantService.getAll()));
        return "restaurants";
    }
}
