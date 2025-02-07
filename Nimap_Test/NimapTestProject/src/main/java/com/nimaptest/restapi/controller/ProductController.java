package com.nimaptest.restapi.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

import com.nimaptest.restapi.dto.ProductDTO;
import com.nimaptest.restapi.entity.Response;
import com.nimaptest.restapi.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	private ProductService service;
	@GetMapping("/products")
	public ResponseEntity<Response<Page<ProductDTO>>> getAllproducts(@RequestParam int page,
			@RequestParam(defaultValue = "5", required = false) int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<ProductDTO> categoriesPage = service.getProducts(pageable);
		Response<Page<ProductDTO>> response = new Response<>();
		response.setMessage("Paginated Products List...");
		response.setStatusCode(HttpStatus.OK.value());
		response.setData(categoriesPage);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping("/add/product")
	public ResponseEntity<Response<ProductDTO>> addProduct(@RequestBody ProductDTO p) {
		ProductDTO product = service.addProduct(p);
		Response<ProductDTO> response = new Response<>();
		response.setMessage("Product Added...");
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setData(product);
		return new ResponseEntity<Response<ProductDTO>>(response, HttpStatus.CREATED);
	}

	@GetMapping("product/{id}")
	public ResponseEntity<Response<ProductDTO>> findProductById(@PathVariable int id) {
		ProductDTO product = service.findProductById(id);
		Response<ProductDTO> response = new Response<>();
		if (product != null) {
			response.setMessage("Product found...");
			response.setStatusCode(HttpStatus.FOUND.value());
			response.setData(product);
		} else {
			response.setMessage("Product Not found...");
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
			response.setData(product);
		}
		return new ResponseEntity<Response<ProductDTO>>(response, HttpStatus.CREATED);
	}
	@PutMapping("/product/{id}")
	public ResponseEntity<Response<ProductDTO>> updateProduct(@PathVariable int id, @RequestBody ProductDTO c) {
		ProductDTO product = service.findProductById(id);
		Response<ProductDTO> response = new Response<>();
		if (product != null) {
			product.setName(c.getName());
			product.setPrice(c.getPrice());
			product.setCategory(c.getCategory());
			if (service.updateProduct(product) != null) {
				response.setMessage("Product Updated...");
				response.setStatusCode(HttpStatus.OK.value());
				response.setData(product);
			} else {
				response.setMessage("Something went wrong...");
				response.setStatusCode(HttpStatus.NOT_FOUND.value());
				response.setData(product);
			}
		} else {
			response.setMessage("Product Not found...");
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
			response.setData(product);
		}

		return new ResponseEntity<Response<ProductDTO>>(response, HttpStatus.CREATED);
	}

	@DeleteMapping("product/{id}")
	public ResponseEntity<Response<ProductDTO>> deleteProductById(@PathVariable int id) {
		ProductDTO product = service.findProductById(id);
		Response<ProductDTO> response = new Response<>();
		if (product != null) {
			service.deleteProductById(id);
			response.setMessage("Product deleted successfully...");
			response.setStatusCode(HttpStatus.FOUND.value());
			response.setData(product);
		} else {
			response.setMessage("Product Not found...");
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
			response.setData(product);
		}
		return new ResponseEntity<Response<ProductDTO>>(response, HttpStatus.CREATED);
	}

	

	
}
