package com.fpoly.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fpoly.config.UserInfoUserDetails;
import com.fpoly.service.UserInfoService;
import com.fpoly.service.UserService;

@Controller
@RequestMapping("/index")
public class HomeController {
	 @Autowired
	    private UserInfoService userService;
	 
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
	
	 @GetMapping("/profile")
	    public String viewProfile(Principal principal, Model model) {
		 UserInfoUserDetails userDetails = (UserInfoUserDetails) userService.loadUserByUsername(principal.getName());
	        model.addAttribute("user", userDetails.getUserInfo());
	        return "views/home/user/layout/profile";
	 }
}
