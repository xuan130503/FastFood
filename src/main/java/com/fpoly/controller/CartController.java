package com.fpoly.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CartController {
	@RequestMapping("/cart/view")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public String view() {
		return "/views/home/user/cart/view";
	}
}
