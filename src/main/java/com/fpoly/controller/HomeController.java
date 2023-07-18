package com.fpoly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/index")
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
	
	@GetMapping("/account")
	public String account() {
		return "views/home/user/layout/login";
	}
}
