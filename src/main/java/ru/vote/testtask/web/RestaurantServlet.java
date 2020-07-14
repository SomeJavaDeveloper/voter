package ru.vote.testtask.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import ru.vote.testtask.model.Restaurant;
import ru.vote.testtask.service.RestaurantService;
import ru.vote.testtask.to.MealTo;
import ru.vote.testtask.to.RestaurantTo;
import ru.vote.testtask.web.meal.MealRestController;
import ru.vote.testtask.web.restaurant.RestaurantRestController;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class RestaurantServlet extends HttpServlet {

    //null
    private RestaurantRestController restaurantController;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        WebApplicationContext springContext = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        restaurantController = springContext.getBean(RestaurantRestController.class);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Restaurant restaurant = new Restaurant(
                req.getParameter("name"),
                req.getParameter("description")
        );
        if(StringUtils.isEmpty(req.getParameter("id"))){
            restaurantController.create(restaurant);
        } else {
            restaurant.setId(Integer.parseInt(req.getParameter("id")));
            restaurantController.update(restaurant);
        }
        resp.sendRedirect("restaurants");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");



        switch (action == null ? "all" : action){
            case "delete":
                int id = getId(req);
                restaurantController.delete(id);
                resp.sendRedirect("restaurants");
                break;
            case "create":
            case "update":
                final Restaurant restaurant = "create".equals(action)?
                        new Restaurant() : restaurantController.get(getId(req));
                req.setAttribute("restaurant", restaurant);
                req.getRequestDispatcher("/restaurantForm.jsp").forward(req, resp);
                break;
            case "all":
            default:
                req.setAttribute("restaurants", restaurantController.getAll());
                req.getRequestDispatcher("/restaurants.jsp").forward(req, resp);
                break;
        }
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }
}
