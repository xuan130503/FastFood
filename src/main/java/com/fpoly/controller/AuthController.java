package com.fpoly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth")
public class AuthController {
	@RequestMapping("/login/form")
	public String formlogin() {
		return "/views/home/user/layout/login";
	}
	@RequestMapping("/login/success")
	public String success(HttpServletRequest request,HttpSession session, Model model) {
		session.setAttribute("currentuser", request.getRemoteUser());
		model.addAttribute("error","Login");
		return "/views/home/user/layout/login";
	}
	@RequestMapping("/login/error")
	public String error(Model model) {
		model.addAttribute("error", "Bạn đã nhập sai tài khoản hoặc mật khẩu, vui lòng kiểm tra lại");
		return "/views/home/user/layout/login";
	}
	@RequestMapping("/access/denied")
	public String denied(Model model) {
		model.addAttribute("error", "Không đủ quyền hạn !");
		return "/views/home/user/layout/login";
	}
}
