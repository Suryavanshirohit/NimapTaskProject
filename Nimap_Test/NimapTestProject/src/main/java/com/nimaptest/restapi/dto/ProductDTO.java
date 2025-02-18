package com.nimaptest.restapi.dto;

import com.nimaptest.restapi.entity.Product;

public class ProductDTO {
	private int id;
	private String name;
	private double price;
	private CategoryDTO category;

	public ProductDTO(Product product) {
		this.id = product.getProduct_Id();
		this.name = product.getProduct_Name();
		this.price = product.getPrice();
		this.category = new CategoryDTO(product.getCategory());
	}

	public ProductDTO() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}


}
