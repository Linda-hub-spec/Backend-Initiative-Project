package com.aijaycodes.movieApp.Persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name="users")
public class UserData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="userId")
	Long userId;
	
	@Column
	//@NotNull(message = "Name cannot be null")
	String name;
	
	@Column
	@Email(message = "Email should be valid(eg. abca@gmail.com)")
	String email;
	
	@Column
	//@NotNull(message = "username cannot be null")
	String username;
	
	@Column
	// @NotNull(message = "password cannot be null")
	String password;
	

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
