package com.example.demo.dao;

import com.example.demo.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders,Integer> {
    @Query(value="select customer_name, group_concat(dish_name) as dishes from orders group by customer_name", nativeQuery=true)
    List<Object[]> findOrders();
    @Query(value="select distinct customer_name from orders", nativeQuery=true)
    List<Object[]> customerList();

  
}
