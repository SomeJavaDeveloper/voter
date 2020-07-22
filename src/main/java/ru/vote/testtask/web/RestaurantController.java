package ru.vote.testtask.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.vote.testtask.model.Restaurant;
import ru.vote.testtask.web.restaurant.RestaurantRestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.Enumeration;
import java.util.Objects;

@Controller
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantRestController controller;

    @PostMapping
    public String postRestaurant(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        Restaurant restaurant = new Restaurant(
                request.getParameter("name"),
                request.getParameter("description"));
        if (StringUtils.isEmpty(getId(request))) {
            controller.create(restaurant);
        } else {
            restaurant.setId(Integer.parseInt(getId(request)));
            controller.update(restaurant);
        }
        return "redirect:restaurants";
    }

    @GetMapping
    public String getRestaurants(HttpServletRequest request, Model model){
        String action = request.getParameter("action");
        switch (action == null ? "all" : action){
            case "delete":
                int id = Integer.parseInt(getId(request));
                controller.delete(id);
                return "redirect:restaurants";
            case "create":
            case "update":
                final Restaurant restaurant = "create".equals(action)?
                        new Restaurant() : controller.get(Integer.parseInt(getId(request)));
                model.addAttribute("restaurant", restaurant);
                return "restaurantForm";
            case "all":
            default:
                model.addAttribute("restaurants", controller.getAll());
                return "restaurants";
        }
    }

    private String getId(HttpServletRequest request) {
        return Objects.requireNonNull(request.getParameter("id"));
    }
}
