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
public class WaiterController {
    @Autowired
    OrdersRepository ordersRepository;

    @RequestMapping("/waiter")
    public String manager()
    {
        return "waiter";
    }
    @RequestMapping("/waiter/ordersToBeServed")
    public ModelAndView ordersToBeServed() {
        // HashMap<String, List<String >> hashMap=new HashMap<>();
       // return ordersRepository.findOrders();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("orders",ordersRepository.findOrders());
        modelAndView.setViewName("ordersToBeServed");
        return modelAndView;



    }
}



