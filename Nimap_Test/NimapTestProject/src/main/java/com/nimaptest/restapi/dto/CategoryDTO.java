package com.nimaptest.restapi.dto;

import com.nimaptest.restapi.entity.Category;

public class CategoryDTO {
	private int id;
	private String name;

	public CategoryDTO(Category category) {
		this.id = category.getId();
		this.name = category.getName();
	}

	public CategoryDTO() {
		super();
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

}
