package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="orders")
public class Orders {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int orderId;
    private String customerName;
    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name="dishName")
    private String dishName;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date orderDate;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
