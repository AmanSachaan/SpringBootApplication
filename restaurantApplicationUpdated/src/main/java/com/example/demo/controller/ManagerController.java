package com.example.demo.controller;

import com.example.demo.dao.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ManagerController {
    @Autowired
    DishRepository dishRepository;
    public String customerName;

    @RequestMapping("/manager")
    public String manager(@ModelAttribute("customerName") String customerName)
    {
        this.customerName=customerName;

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject(customerName);
        modelAndView.setViewName("manager");
        return "manager";
    }

    @RequestMapping("/manager/generateBill")
    public ModelAndView generateBill(@RequestParam("customerName") String customerName)
    {
        ModelAndView modelAndView =new ModelAndView();
        List<Object[]> billList=dishRepository.generateBill(customerName);
        List<Object[]> billDishes=dishRepository.generateBillWithDishes(customerName);
        modelAndView.addObject("bill",billList);
        modelAndView.addObject("billDishes",billDishes);
        System.out.println(billList.get(0)[0]);
        if(billList.get(0)[0]==null)
        modelAndView.setViewName("invalidName");
        else
        modelAndView.setViewName("generateBill");
        return modelAndView;
    }
}
