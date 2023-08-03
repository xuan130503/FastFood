package com.fpoly.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/index")
public class HomeController {
	@GetMapping()
	public String index() {
		return "views/home/user/layout/home";
	}
	
	@GetMapping("/about")
	public String about() {
		return "views/home/user/layout/about";
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "views/home/user/layout/contact";
	}
}
