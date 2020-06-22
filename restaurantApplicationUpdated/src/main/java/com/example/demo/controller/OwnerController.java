package com.example.demo.controller;

import com.example.demo.dao.DishRepository;
import com.example.demo.dao.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.sql.Date;
import java.util.List;

@Controller
public class OwnerController {
    @Autowired
    DishRepository dishRepository;
    @Autowired
    OrdersRepository ordersRepository;
    @RequestMapping("/owner")
    public String owner() throws CustomException
    {
        return "owner";
    }
    @RequestMapping("/owner/getCollections")
    public ModelAndView getCollections(@RequestParam("fromDate") Date fromdate , @RequestParam("toDate") Date toDate)
    {

        List<Object[]> collections= dishRepository.generateBill(fromdate,toDate);
        ModelAndView modelAndView=new ModelAndView();
        System.out.println(collections.get(0)[0]);
        modelAndView.addObject("collections",collections);
        modelAndView.setViewName("getCollections");
        return modelAndView;
    }

    @RequestMapping("/owner/getCustomerList")
    public ModelAndView getCollections()
    {

        List<Object[]> customerList= ordersRepository.customerList();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("customerList",customerList);
        modelAndView.setViewName("getCustomerList");
        return modelAndView;
    }
}




