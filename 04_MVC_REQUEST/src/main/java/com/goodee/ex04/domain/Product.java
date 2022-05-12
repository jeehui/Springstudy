package com.goodee.ex04.domain;

public class Product {
	
	private String models;
	private int price;
	
	//default Constructor
	public Product() {
		
	}

	
	public Product(String models, int price) {
		super();
		this.models = models;
		this.price = price;
	}


	public String getModels() {
		return models;
	}

	public void setModels(String models) {
		this.models = models;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	

	
}
