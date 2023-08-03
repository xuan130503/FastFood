package com.fpoly.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fpoly.entity.Product;
import com.fpoly.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService prodService;
	
	@RequestMapping("/product/list")
	public String list(Model model, @RequestParam("cid") Optional<String> cid) {
		if(cid.isPresent()) {
			List<Product> list = prodService.findByCategoryId(cid.get());
			model.addAttribute("food_items", list);
		} else {
			List<Product> list = prodService.findAll();
			model.addAttribute("food_items", list);
		}
		return "views/home/user/product/list";
	}
	
	@RequestMapping("/product/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Product detail_food = prodService.findById(id);
		model.addAttribute("food_items", detail_food);
		return "views/home/user/product/detail";
	}
}
