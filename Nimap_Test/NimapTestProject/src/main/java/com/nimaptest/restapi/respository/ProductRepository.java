package com.nimaptest.restapi.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nimaptest.restapi.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
