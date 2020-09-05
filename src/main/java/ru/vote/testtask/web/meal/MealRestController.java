package ru.vote.testtask.web.meal;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.vote.testtask.model.Meal;
import ru.vote.testtask.to.MealTo;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = MealRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class MealRestController extends AbstractMealController {

    static final String REST_URL = "/rest/restaurants/{restaurantId}/meals";

    @Override
    @GetMapping
    public List<MealTo> getAll(@PathVariable("restaurantId") int restaurantId) {
        return super.getAll(restaurantId);
    }

    @Override
    @GetMapping("/{id}")
    public Meal get(@PathVariable("restaurantId") int restaurantId, @PathVariable("id") int mealId) {
        return super.get(restaurantId, mealId);
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int mealId) {
        super.delete(mealId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Meal> createMeal(@PathVariable("restaurantId") int restaurantId, @RequestBody Meal meal) {
        Meal created = super.create(restaurantId, meal);
        URI uriOfNewMeal = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/" + created.getId())
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewMeal).body(created);
    }

    @Override
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Meal update(@PathVariable("restaurantId") int restaurantId, @RequestBody Meal meal) {
        return super.update(restaurantId, meal);
    }
}
