package com.fpoly.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fpoly.entity.UserInfo;

@RestController
@RequestMapping("/api")
public class AccountRestController {

    private UserInfo loggedInAccount = new UserInfo();

    // Endpoint để lấy thông tin tài khoản đang đăng nhập
    @GetMapping("/account")
    public UserInfo getLoggedInAccount() {
        return loggedInAccount;
    }

    // Endpoint để cập nhật thông tin tài khoản đang đăng nhập
    @PutMapping("/account")
    public String updateLoggedInAccount(@RequestBody UserInfo updatedAccount) {
        loggedInAccount.setUsername(updatedAccount.getUsername());
        loggedInAccount.setEmail(updatedAccount.getEmail());
        return "Account updated successfully";
    }
}