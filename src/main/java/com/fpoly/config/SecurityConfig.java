package com.fpoly.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.fpoly.dao.UserInfoRepository;
import com.fpoly.service.UserInfoService;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	private final UserInfoRepository repository;
	@Bean
    public UserDetailsService userDetailsService() {
		return new UserInfoService(repository);
    }
     @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
     
     @Bean
     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http.csrf().disable()
                     .authorizeHttpRequests()
                     .requestMatchers("/**").permitAll() // với endpoint /hello thì sẽ được cho qua
                     .and()
                     .authorizeHttpRequests()
                     .requestMatchers("/cart/view","/product").authenticated() // với endpoint /customer/** sẽ yêu cầu authenticate
                     .and().formLogin().loginPage("/auth/login/form").loginProcessingUrl("/auth/login")
                     .defaultSuccessUrl("/index", true)
                     .failureUrl("/auth/login/error")
                     .usernameParameter("username").passwordParameter("password");
            http.logout().logoutUrl("/auth/logoff").logoutSuccessUrl("/index");// trả về page login nếu chưa authenticate
            return http.build();
     }
     
     @Bean
     public AuthenticationProvider authenticationProvider(){
         DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
         authenticationProvider.setUserDetailsService(userDetailsService());
         authenticationProvider.setPasswordEncoder(passwordEncoder());
         return authenticationProvider;
     }

}
