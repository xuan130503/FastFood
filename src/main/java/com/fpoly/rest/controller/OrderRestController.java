package com.fpoly.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fpoly.entity.Order;
import com.fpoly.service.OrderService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest")
public class OrderRestController {
	@Autowired
	OrderService orderService;
	
	@PostMapping("/orders")
	public Order create(@RequestBody JsonNode orderData) {
		return orderService.create(orderData);
	}
}
