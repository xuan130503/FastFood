package com.fpoly.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.fpoly.config.UserInfoUserDetails;
import com.fpoly.entity.UserInfo;
import com.fpoly.dao.UserInfoDAO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserInfoService implements UserDetailsService {

	  private final UserInfoDAO userInfoDAO;

	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        Optional<UserInfo> userInfo = userInfoDAO.findByUsername(username);
	        return userInfo.map(UserInfoUserDetails::new)
	                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

	    }
}
