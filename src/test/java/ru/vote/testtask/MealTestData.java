package ru.vote.testtask;

import ru.vote.testtask.model.Meal;

import java.util.Arrays;
import java.util.List;

public class MealTestData {

    public static final Meal MEAL1 = new Meal(100002, "meal 1 re 1", 100);
    public static final Meal MEAL2 = new Meal(100003, "meal 2 re 1", 200);
    public static final List<Meal> RESTAURANT1_MEALS = Arrays.asList(MEAL1, MEAL2);

    public static final Meal MEAL3 = new Meal(100004, "meal 1 re 2", 300);
    public static final Meal MEAL4 = new Meal(100005, "meal 2 re 2", 400);
    public static final List<Meal> RESTAURANT2_MEALS = Arrays.asList(MEAL3, MEAL4);

    public static Meal getNew() {
        return new Meal(null, "new meal", 101);
    }

    public static Meal getUpdated() {
        return new Meal(100002, "meal 1 re 1 updated", 110);
    }
}
