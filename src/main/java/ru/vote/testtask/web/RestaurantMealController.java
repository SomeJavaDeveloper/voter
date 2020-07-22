package ru.vote.testtask.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.vote.testtask.model.Meal;
import ru.vote.testtask.model.Restaurant;
import ru.vote.testtask.web.meal.MealRestController;
import ru.vote.testtask.web.restaurant.RestaurantRestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Objects;

@Controller
public class RestaurantMealController {

    @Autowired
    private MealRestController mealController;
    @Autowired
    private RestaurantRestController restaurantController;

    @PostMapping("/restaurantMeals")
    public String postRestaurantMeals(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        Meal meal = new Meal(
                request.getParameter("name"),
                Integer.parseInt(request.getParameter("price"))
        );
        String restaurantId = getRequiredId("restaurantId", request);

        if(StringUtils.isEmpty(getRequiredId("id", request))){
            mealController.create(Integer.parseInt(restaurantId), meal);
        } else {
            meal.setId(Integer.valueOf(getRequiredId("id", request)));
            mealController.update(Integer.parseInt(restaurantId), meal);
        }

        return "redirect:restaurantMeals?restaurantId=" + restaurantId;
    }

    @GetMapping("/restaurantMeals")
    public String getRestaurantMeals(HttpServletRequest request, Model model) {
        String action = request.getParameter("action");
        int restaurantId = Integer.parseInt(getRequiredId("restaurantId", request));

        switch (action == null ? "all" : action) {
            case "delete":
                mealController.delete(Integer.parseInt(getRequiredId("id", request)));
                return "redirect:restaurantMeals?restaurantId=" + restaurantId;
            case "create":
            case "update":
                final Meal meal = "create".equals(action) ?
                        new Meal() : mealController.get(restaurantId, Integer.parseInt(getRequiredId("id", request)));
                model.addAttribute("restaurant", restaurantController.get(restaurantId));
                model.addAttribute("meal", meal);
                return "mealForm";
            case "all":
            default:
                model.addAttribute("restaurant", restaurantController.get(restaurantId));
                model.addAttribute("meals", mealController.getAll(restaurantId));
                return "restaurantMeals";
        }
    }

    private String getRequiredId (String id, HttpServletRequest request){
        return Objects.requireNonNull(request.getParameter(id));
    }
}
