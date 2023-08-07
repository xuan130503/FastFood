package com.fpoly.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fpoly.entity.Product;
import com.fpoly.service.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/products")
public class ProductRestController {
	@Autowired
	ProductService prodService;
	
	@GetMapping("{id}")
	public Product getOne(@PathVariable("id") Integer id) {
		return prodService.findById(id);
	}
	
	@GetMapping()
	public List<Product> getAll() {
		return prodService.findAll();
	}
	
	@PostMapping
	public Product create(@RequestBody Product product) {
		return prodService.create(product);
	}
	
	@PutMapping("{id}")
	public Product update(@RequestBody Product product, @PathVariable("id") Integer id) {
		return prodService.update(product);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		prodService.delete(id);
	}
}
