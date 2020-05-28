package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Laptop {
	
	private String brand;
	private int price;
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void compile() {
		// TODO Auto-generated method stub
		System.out.println("this is student laptop");
		
	}

}
