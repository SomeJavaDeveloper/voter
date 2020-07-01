package ru.vote.testtask.web;

import ru.vote.testtask.model.Restaurant;
import ru.vote.testtask.web.meal.MealRestController;
import ru.vote.testtask.web.restaurant.RestaurantRestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MealServlet extends HttpServlet {

    private RestaurantRestController restaurantController = new RestaurantRestController();
    private MealRestController mealController = new MealRestController();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("restaurant_id"));
        Restaurant restaurant = restaurantController.get(id);
        req.setAttribute("restaurantName", restaurant.getName());
        req.setAttribute("meals", mealController.getAll(id));

        req.getRequestDispatcher("/restaurantMeals.jsp").forward(req, resp);
    }
}
