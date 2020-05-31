package com.example.demo.controller;

import com.example.demo.dao.DishRepository;
import com.example.demo.dao.OrdersRepository;
import com.example.demo.model.Dish;
import com.example.demo.model.Orders;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class RestaurantController {
    @Autowired
    DishRepository dishRepository;
    @Autowired
    OrdersRepository ordersRepository;

    @GetMapping("/getDishes")
    public List<Dish> getDishes() {
        return (List<Dish>) dishRepository.findAll();
    }

    @PostMapping("/addDishes")
    public Dish addDishes(@RequestBody Dish dish) {
        dishRepository.save(dish);
        return dish;
    }

    @GetMapping("/getOrder")
    public List<Orders> getOrder() {
        return (List<Orders>) ordersRepository.findAll();
    }

    @PostMapping("/createOrder")
    public Orders createOrder(@RequestBody Orders orders) {
        ordersRepository.save(orders);
        return orders;
    }

}