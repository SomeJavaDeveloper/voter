package ru.vote.testtask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ru.vote.testtask.model.Meal;
import ru.vote.testtask.model.Restaurant;

import static org.junit.jupiter.api.Assertions.*;

public class RestaurantTestData {

    public static final Restaurant RESTAURANT1 = new Restaurant(
            100000, "first restaurant", "fi re desc",
                MealTestData.RESTAURANT1_MEALS);
    public static final Restaurant RESTAURANT2 = new Restaurant(
            100001, "sec restaurant", "se re desc",
            MealTestData.RESTAURANT2_MEALS);
    public static final List<Restaurant> RESTAURANTS = Arrays.asList(RESTAURANT1, RESTAURANT2);
    public static final Restaurant[] RESTAURANTS_ARRAY = {RESTAURANT1, RESTAURANT2};

    public static Restaurant getNew() {
        return new Restaurant(null, "new rest", "new rest desc");
    }

    public static Restaurant getUpdated() {
        return new Restaurant(RESTAURANT1.getId(), "first restaurant updated", "fi re desc updated", MealTestData.RESTAURANT1_MEALS);
    }
}