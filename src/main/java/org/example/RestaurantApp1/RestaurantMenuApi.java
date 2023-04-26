package org.example.RestaurantApp1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/menu")
public class RestaurantMenuApi {

    private List<RestaurantMenu> restaurantMenu;

    public RestaurantMenuApi() {
        restaurantMenu = new ArrayList<>();
        restaurantMenu.add(new RestaurantMenu(1L,"Pizza"));
        restaurantMenu.add(new RestaurantMenu(2L,"Pasta"));
        restaurantMenu.add(new RestaurantMenu(3L,"Salads"));
        restaurantMenu.add(new RestaurantMenu(4L,"Beverages"));
    }

    @GetMapping("/all")
    public List<RestaurantMenu> getAll(){
        return restaurantMenu;
    }
    @GetMapping
    public RestaurantMenu getById(@RequestParam int index){
        Optional<RestaurantMenu> first = restaurantMenu.stream().filter(element -> element.getId() == index).findFirst();
        return first.get();
    }
}
