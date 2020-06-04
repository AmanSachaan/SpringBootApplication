package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="dish")
public class Dish {
    @Id
    private String dishName;
    private int dishCost;
    @OneToMany(targetEntity = Orders.class)
    @JoinColumn(name = "fk",referencedColumnName = "dishName")
    private List<Orders> orders;

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public int getDishCost() {
        return dishCost;
    }

    public void setDishCost(int dishCost) {
        this.dishCost = dishCost;
    }


}
