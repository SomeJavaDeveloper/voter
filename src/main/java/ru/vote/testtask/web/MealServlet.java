package ru.vote.testtask.web;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;
import ru.vote.testtask.model.Meal;
import ru.vote.testtask.model.Restaurant;
import ru.vote.testtask.web.meal.MealRestController;
import ru.vote.testtask.web.restaurant.RestaurantRestController;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;


public class MealServlet extends HttpServlet {

    private ConfigurableApplicationContext springContext;
    private MealRestController mealController;
    private RestaurantRestController restaurantController;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        springContext = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        mealController = springContext.getBean(MealRestController.class);
        restaurantController = springContext.getBean(RestaurantRestController.class);
    }

    @Override
    public void destroy() {
        springContext.close();
        super.destroy();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Meal meal = new Meal(
                req.getParameter("name"),
                Integer.parseInt(req.getParameter("price"))
        );
        int restaurantId = Integer.parseInt(req.getParameter("restaurantId"));


        if(StringUtils.isEmpty(req.getParameter("id"))){
            mealController.create(restaurantId, meal);
        } else {
            meal.setId(Integer.parseInt(req.getParameter("id")));
            mealController.update(restaurantId, meal);
        }
        resp.sendRedirect("restaurantMeals");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int restaurantId = Integer.parseInt(req.getParameter("restaurant_id"));
        Restaurant restaurant = restaurantController.get(restaurantId);
        req.setAttribute("restaurantName", restaurant.getName());

        String action = req.getParameter("action");

        req.setAttribute("urlRestaurantId", restaurantId);

        switch (action == null ? "all" : action){
            case "delete":
                int mealId = getId(req);
                mealController.delete(restaurantId, mealId);
                resp.sendRedirect("restaurantMeals");
                req.getRequestDispatcher("/restaurantForm.jsp").forward(req, resp);
                break;
            case "create":
            case "update":
                final Meal meal = "create".equals(action)?
                        new Meal() : mealController.get(restaurantId, getId(req));
                req.setAttribute("meal", meal);
                req.getRequestDispatcher("/mealForm.jsp").forward(req, resp);
                break;
            case "all":
            default:
                req.setAttribute("meals", mealController.getAll(restaurantId));
                req.getRequestDispatcher("/restaurantMeals.jsp").forward(req, resp);
            break;
        }
    }
    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }
}
