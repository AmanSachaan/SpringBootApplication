/*Customers come to a restaurant and order dishes for lunch. Pay the bill and go home. create an app for a restaurant
  where
		1. Waiter can see orders to be served to customers,
		2, Manager should be able to generate the bill of a particular customer.
		3. Restaurant owner can see all the amount he made  in that particular date range(month, or by day or by week).

		Assume there is a single restaurant and single branch only. Come up with your own tables, classes and apis in
		spring boot.

		Expectation is the assignment should be demonstrated by curl/postman. All apis can be accessed by everyone:
		manager,waiter and restaurant owner. Use appropriate data structures and helper functions. The code is neat
		and aligned with our clean code standards.  The code is committed to Git.
*/
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantApplication.class, args);
	}

}
