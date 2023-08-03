package com.fpoly.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpoly.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer>{
	Optional<UserInfo> findByUsername(String username);
}
