package com.nimaptest.restapi.service;

import org.springframework.stereotype.Service;

import com.nimaptest.restapi.dto.CategoryDTO;
import com.nimaptest.restapi.dto.ProductDTO;
import com.nimaptest.restapi.entity.Category;
import com.nimaptest.restapi.entity.Product;
import com.nimaptest.restapi.respository.CategoryRepository;
import com.nimaptest.restapi.respository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

@Service
public class ProductService {

	@Autowired
	ProductRepository repo;

	@Autowired
	CategoryRepository categoryRepo;
	
	public Page<ProductDTO> getAllProducts(Pageable pageable) {
		Page<Product> productsPage = repo.findAll(pageable);
		List<ProductDTO> productDTOList = new ArrayList<>();
		for (Product p : productsPage.getContent()) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setId(p.getProduct_Id());
			productDTO.setName(p.getProduct_Name());
			productDTO.setPrice(p.getPrice());
			Category category = p.getCategory();
			CategoryDTO categoryDTO = new CategoryDTO();
			categoryDTO.setId(category.getId());
			categoryDTO.setName(category.getName());
			productDTO.setCategory(categoryDTO);
			productDTOList.add(productDTO);
		}

		Page<ProductDTO> productDTOPage = new PageImpl<>(productDTOList);
		return productDTOPage;
	}


	public ProductDTO addProduct(ProductDTO p) {
		Category category;
		category = categoryRepo.findById((long) p.getCategory().getId()).orElse(null);

		Product product = new Product();
		product.setProduct_Name(p.getName());
		product.setPrice(p.getPrice());
		product.setCategory(category);
		Product savedProduct = repo.save(product);
		return new ProductDTO(savedProduct);
	}

	public ProductDTO findProductById(int id) {
		Product p = repo.findById((long) id).orElse(null);
		if (p == null) {
			return null;
		}
		CategoryDTO category1 = new CategoryDTO();
		Category category = categoryRepo.findById((long) p.getCategory().getId()).orElse(null);
		category1.setId(category.getId());
		category1.setName(category.getName());
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(p.getProduct_Id());
		productDTO.setName(p.getProduct_Name());
		productDTO.setPrice(p.getPrice());
		productDTO.setCategory(category1);
		return productDTO;
	}

	public ProductDTO updateProduct(ProductDTO p) {
		Category category;
		category = categoryRepo.findById((long) p.getCategory().getId()).orElse(null);
		if (category != null) {
			Product product = new Product();
			product.setProduct_Id(p.getId());
			product.setProduct_Name(p.getName());
			product.setPrice(p.getPrice());
			product.setCategory(category);
			Product savedProduct = repo.save(product);
			return new ProductDTO(savedProduct);
		} else {
			return null;
		}
	}

	public void deleteProductById(int id) {
		repo.deleteById((long) id);
	}	
	

}
