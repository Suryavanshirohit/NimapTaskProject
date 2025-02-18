package com.nimaptest.restapi.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nimaptest.restapi.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
