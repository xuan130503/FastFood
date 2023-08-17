package com.fpoly.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Userinfo")
public class UserInfo implements Serializable {
	@Id
	private String username;
    private String password;
	@Column(columnDefinition = "NVARCHAR(255) NOT NULL")
    private String lastname;
	@Column(columnDefinition = "NVARCHAR(255) NOT NULL")
    private String firstname;
    private String email;
    private String photo;
    private String roles;
    @JsonIgnore
	@OneToMany(mappedBy = "userinfo")
	List<Order> orders;
	
}
