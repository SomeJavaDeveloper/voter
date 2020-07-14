package ru.vote.testtask.web.restaurant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import ru.vote.testtask.model.Restaurant;
import ru.vote.testtask.service.RestaurantService;
import ru.vote.testtask.to.RestaurantTo;
import ru.vote.testtask.util.RestaurantUtil;

import java.util.List;

@Controller
public class RestaurantRestController {

    private static final Logger log = LoggerFactory.getLogger(RestaurantRestController.class);

    private RestaurantService service;

    public RestaurantRestController(RestaurantService service) {
        this.service = service;
    }

    public List<RestaurantTo> getAll(){
        log.info("getAll() restaurants");
        return RestaurantUtil.getTos(service.getAll());
    }

    public void delete(int id){
        log.info("delete() restaurants");
        service.delete(id);
    }

    public Restaurant create(Restaurant restaurant){
        return service.create(restaurant);
    }

    public Restaurant update(Restaurant restaurant){
        return service.update(restaurant);
    }

    public Restaurant get(int id){
        return service.get(id);
    }
}
