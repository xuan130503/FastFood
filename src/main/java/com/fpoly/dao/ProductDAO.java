package com.fpoly.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fpoly.entity.Product;

public interface ProductDAO extends JpaRepository<Product, Integer>{
	@Query("SELECT p FROM Product p WHERE p.category.id = ?1")
	List<Product> findByCategoryId(String cid);
}
