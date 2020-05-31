package com.example.demo.controller;

import com.example.demo.dao.DishRepository;
import com.example.demo.dao.OrdersRepository;
import com.example.demo.model.Dish;
import com.example.demo.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
public class WaiterController {
    @Autowired
    OrdersRepository ordersRepository;

    //    @GetMapping("/ordersToBeServed")
//    public HashMap<String, List<String >> ordersToBeServed()
//    {
//        HashMap<String, List<String >> hashMap=new HashMap<>();
//        ordersRepository.findOrders();
//        return hashMap;
//    }
    @GetMapping("/ordersToBeServed")
    public List<Object> ordersToBeServed() {
        // HashMap<String, List<String >> hashMap=new HashMap<>();
        return ordersRepository.findOrders();

    }
}
