package com.nimaptest.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nimaptest.restapi.entity.Category;
import com.nimaptest.restapi.respository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository repo;
	
	public Page<Category> getAllCategoryList(Pageable pageable) {
		return repo.findAll(pageable);
	}

	public Category addCatagoryInList(Category cate) {
		return repo.save(cate);
	}

	public Category getCatagoryById(int id) {
		return repo.findById((long) id).orElse(null);
	}

	public Category updateCatagoryById(int id, Category category) {
		return repo.save(category);
	}

	public Category deleteCatagoryById(int id) {
		repo.deleteById((long) id);
		return null;
	}

	

}
