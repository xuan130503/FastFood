package com.fpoly.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/index")
public class HomeController {
	@RequestMapping({"/admin","/admin/home/index"})
	public String admin() {
		return "redirect:/assets/admin/index.html";
	}
	
	@GetMapping()
	public String index() {
		return "views/home/user/layout/home";
	}
	
	@RequestMapping("/registry")
	public String registry() {
		return "views/home/user/layout/registry";
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
