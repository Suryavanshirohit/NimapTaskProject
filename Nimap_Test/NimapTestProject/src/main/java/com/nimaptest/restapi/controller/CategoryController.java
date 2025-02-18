package com.nimaptest.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nimaptest.restapi.entity.Category;
import com.nimaptest.restapi.entity.Response;
import com.nimaptest.restapi.service.CategoryService;

@RestController
@RequestMapping("/restapi")
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/categories")
	public ResponseEntity<Response<Page<Category>>> getAllCategories(@RequestParam("page") int page,
			@RequestParam(defaultValue = "5", required = false) int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Category> categoriesPage = categoryService.getAllCategoryList(pageable);
		Response<Page<Category>> response = new Response<>();
		response.setMessage("Categories List...");
		response.setStatusCode(HttpStatus.OK.value());
		response.setData(categoriesPage);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping("/add/category")
	public ResponseEntity<Response<Category>> addCatagory(@RequestBody Category c) {
		Category catagory = categoryService.addCatagoryInList(c);
		Response<Category> response = new Response<>();
		response.setMessage("Catagory Added...");
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setData(catagory);
		return new ResponseEntity<Response<Category>>(response, HttpStatus.CREATED);
	}

	@GetMapping("category/{id}")
	public ResponseEntity<Response<Category>> findCatagoryById(@PathVariable int id) {
		Category catagory = categoryService.getCatagoryById(id);
		Response<Category> response = new Response<>();
		if (catagory != null) {
			response.setMessage("Catagory found");
			response.setStatusCode(HttpStatus.FOUND.value());
			response.setData(catagory);
		} else {
			response.setMessage("Catagory Not found");
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
			response.setData(catagory);
		}
		return new ResponseEntity<Response<Category>>(response, HttpStatus.CREATED);
	}
	@PutMapping("/category/{id}")
	public ResponseEntity<Response<Category>> updateCatagory(@PathVariable int id, @RequestBody Category c) {
		Category catagory = categoryService.updateCatagoryById(id,c);
		Response<Category> response = new Response<>();
		if (catagory != null) {
			catagory.setName(c.getName());
			categoryService.getCatagoryById(id);
			response.setMessage("Catagory Updated...");
			response.setStatusCode(HttpStatus.OK.value());
			response.setData(catagory);
		} else {
			response.setMessage("Catagory Not found...");
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
			response.setData(catagory);
		}

		return new ResponseEntity<Response<Category>>(response, HttpStatus.CREATED);
	}

	@DeleteMapping("/category/{id}")
	public ResponseEntity<Response<Category>> deleteCatagoryById(@PathVariable int id) {
		Category catagory = categoryService.deleteCatagoryById(id);
		categoryService.deleteCatagoryById(id);
		Response<Category> response = new Response<>();
		if (catagory != null) {
			response.setMessage("Catagory deleted successfully");
			response.setStatusCode(HttpStatus.FOUND.value());
			response.setData(catagory);
		} else {
			response.setMessage("Catagory Not found");
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
			response.setData(catagory);
		}
		return new ResponseEntity<Response<Category>>(response, HttpStatus.CREATED);
	}

	


}
