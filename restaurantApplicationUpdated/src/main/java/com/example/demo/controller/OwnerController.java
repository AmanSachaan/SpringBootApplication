package com.example.demo.controller;

import com.example.demo.dao.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Date;

@Controller
public class OwnerController {
    @Autowired
    DishRepository dishRepository;
    @RequestMapping("/owner")
    public String owner()
    {
        return "owner";
    }
    @RequestMapping("/owner/getCollections/{fromDate}/{toDate}")
    public String getCollections(@PathVariable("fromDate") Date fromdate ,@PathVariable("toDate") Date toDate)
    {
        String collections=" The collections between "+fromdate+ " to " +toDate +" is "+
                dishRepository.generateBill(fromdate,toDate)+" Rupees";
        return collections;
    }
}




