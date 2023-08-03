package com.fpoly.service;

import java.util.List;
import java.util.Optional;

import com.fpoly.entity.Product;

public interface ProductService {
	List<Product> findAll();

	Product findById(Integer id);

	List<Product> findByCategoryId(String cid);
}
