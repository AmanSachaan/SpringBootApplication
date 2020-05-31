package com.example.demo.controller;

import com.example.demo.dao.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagerController {
    @Autowired
    DishRepository dishRepository;
    @GetMapping("/generateBill/{customerName}")
    public String generateBill(@PathVariable("customerName") String customerName)
    {
        String bill="The bill generated for "+customerName+" is " +
                dishRepository.generateBill(customerName)+" Rupees";
        return bill;
    }
}
