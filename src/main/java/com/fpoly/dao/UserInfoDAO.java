package com.fpoly.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpoly.entity.UserInfo;

public interface UserInfoDAO extends JpaRepository<UserInfo, String>{
	Optional<UserInfo> findByUsername(String username);
}
