package ru.vote.testtask.web.restaurant;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.vote.testtask.model.Restaurant;
import ru.vote.testtask.web.SecurityUtil;
import ru.vote.testtask.web.restaurant.RestaurantRestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.Enumeration;
import java.util.Objects;

@Controller
@RequestMapping("/restaurants")
public class JspRestaurantController extends AbstractRestaurantController{

    @GetMapping("/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public String delete(HttpServletRequest request) {
        super.delete(getId(request));
        return "redirect:/restaurants";
    }

    @GetMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public String update(HttpServletRequest request, Model model) {
        model.addAttribute("restaurant", super.get(getId(request)));

        return "restaurantForm";
    }

    @GetMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public String create(Model model) {
        model.addAttribute("restaurants", new Restaurant());
        return "restaurantForm";
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')") ///////////////////////////////////////////////////
    public String updateOrCreate (HttpServletRequest request) {
        Restaurant restaurant = new Restaurant(request.getParameter("name"),
                                request.getParameter("description"));

        if (request.getParameter("id").isEmpty()){
            super.create(restaurant);
        } else {
            restaurant.setId(getId(request));
            super.update(restaurant);
        }
        return "redirect:/restaurants";
    }

    @GetMapping("/vote")
    public String vote(HttpServletRequest request) {
        super.vote(SecurityUtil.authUserId(), getId(request));
        return "redirect:/restaurants";
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }
}
