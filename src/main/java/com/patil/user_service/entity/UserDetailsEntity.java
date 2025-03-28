package com.patil.user_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table (name = "user_details")
@Data
public class UserDetailsEntity {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Long id;
	String userName;
	String email;
	String password;
	String role;

}
