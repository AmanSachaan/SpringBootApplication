package com.example.demo.dao;

import com.example.demo.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface DishRepository extends JpaRepository<Dish, String> {
      @Query(value = "select customer_name, sum(dish_cost) from dish inner join orders where dish.dish_name=orders.dish_name and orders.customer_name=?1",nativeQuery = true)
      List<Object[]> generateBill(String customerName);

      @Query(value = "select sum(dish_cost) from dish inner join orders where dish.dish_name=orders.dish_name and orders.order_date between ?1 and ?2",nativeQuery = true)
      List<Object[]> generateBill(Date fromdate, Date toDate);

      @Query(value = "select dish_name,dish_cost from dish",nativeQuery = true)
      List<Object[]> findAllDishes();
}
