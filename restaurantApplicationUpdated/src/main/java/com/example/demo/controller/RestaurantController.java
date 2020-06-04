package com.example.demo.controller;

import com.example.demo.dao.DishRepository;
import com.example.demo.dao.OrdersRepository;
import com.example.demo.model.Dish;
import com.example.demo.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RestaurantController {
    @Autowired
    DishRepository dishRepository;
    @Autowired
    OrdersRepository ordersRepository;

    @RequestMapping("/")
    public String home()
    {
        //ModelAndView modelAndView=new ModelAndView("h");
        //modelAndView.addObject()
        return "home";
    }


    @RequestMapping("/getDishes")
    public ModelAndView getDishes() {
     ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("dishes",dishRepository.findAllDishes());
        modelAndView.setViewName("getDishes");
        return modelAndView;
    }

    @RequestMapping("/addDishes")
    public Dish addDishes(@RequestBody Dish dish) {
        dishRepository.save(dish);
        return dish;
    }

    @RequestMapping("/getOrder")
    public List<Orders> getOrder() {
        return (List<Orders>) ordersRepository.findAll();
    }

    @RequestMapping("/createOrder")
    public Orders createOrder(@RequestBody Orders orders) {
        ordersRepository.save(orders);
        return orders;
    }

}