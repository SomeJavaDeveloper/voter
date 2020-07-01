package ru.vote.testtask.util;

import ru.vote.testtask.model.Meal;
import ru.vote.testtask.to.MealTo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MealUtil {

    private MealUtil() {
    }

    public static List<MealTo> getTos(Collection<Meal> meals) {
        return filterByPredicate(meals, meal -> true);
    }

    public static List<MealTo> filterByPredicate(Collection<Meal> meals, Predicate<Meal> filter) {

        return meals.stream()
                .filter(filter)
                .map(MealUtil::createTo)
                .collect(Collectors.toList());
    }

    private static MealTo createTo(Meal meal) {
        return new MealTo(meal.getId(), meal.getName(), meal.getPrice());
    }
}
