package com.example.demo.dao;

import com.example.demo.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.sql.Date;

public interface DishRepository extends JpaRepository<Dish, String> {
      @Query(value = "select sum(dish_cost) from dish inner join orders where dish.dish_name=orders.dish_name and orders.customer_name=?1",nativeQuery = true)
      String generateBill(String customerName);

      @Query(value = "select sum(dish_cost) from dish inner join orders where dish.dish_name=orders.dish_name and orders.order_date between ?1 and ?2",nativeQuery = true)
      String generateBill(Date fromdate, Date toDate);
}
