package com.fpoly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpoly.dao.ProductDAO;
import com.fpoly.entity.Product;
import com.fpoly.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductDAO prodDAO;
	@Override
	public List<Product> findAll() {
		return prodDAO.findAll();
	}
	@Override
	public Product findById(Integer id) {
		return prodDAO.findById(id).get();
	}
	@Override
	public List<Product> findByCategoryId(String cid) {
		return prodDAO.findByCategoryId(cid);
	}
	
	@Override
	public Product create(Product product) {
		return prodDAO.save(product);
	}

	@Override
	public Product update(Product product) {
		return prodDAO.save(product);
	}

	@Override
	public void delete(Integer id) {
		prodDAO.deleteById(id);
	}
}
