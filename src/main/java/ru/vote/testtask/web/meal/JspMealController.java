package ru.vote.testtask.web.meal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.vote.testtask.model.Meal;
import ru.vote.testtask.model.Restaurant;
import ru.vote.testtask.util.MealUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
@RequestMapping("/restaurants/{id}/meals")
public class JspMealController extends AbstractMealController{

    @GetMapping
    public String getAll(HttpServletRequest request, Model model, @PathVariable("id") int restaurantId) {
        String uri = request.getRequestURI();
        model.addAttribute("restaurant", super.getRestaurant(restaurantId));
        model.addAttribute("meals", MealUtil.getTos(super.getAll(restaurantId)));
        return "restaurantMeals";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest request, @PathVariable("id") int restaurantId) {
        super.delete(getId(request));
        return "redirect:/restaurants/"+restaurantId+"/meals";
    }

    @GetMapping("/update")
    public String update(HttpServletRequest request, Model model, @PathVariable("id") int restaurantId) {
        model.addAttribute("meal", super.get(restaurantId, getId(request)));
        model.addAttribute("restaurantId", restaurantId);
        return "mealForm";
    }

    @GetMapping("/create")
    public String create(HttpServletRequest request, Model model, @PathVariable("id") int restaurantId) {
        model.addAttribute("meal", new Meal());
        model.addAttribute("restaurantId", restaurantId);
        return "mealForm";
    }

    @PostMapping
    public String createOrUpdate(HttpServletRequest request, @PathVariable("id") int restaurantId) {
        Meal meal = new Meal(request.getParameter("name"),
                    Integer.parseInt(request.getParameter("price")));
        if(request.getParameter("id").isEmpty()){
            super.create(restaurantId, meal);
        } else {
            meal.setId(getId(request));
            super.update(restaurantId, meal);
        }
        return "redirect:/restaurants/"+restaurantId+"/meals";
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }
}
