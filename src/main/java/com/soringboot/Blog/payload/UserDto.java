package com.soringboot.Blog.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserDto {
	private long id;
	@NotEmpty
	@Size(min=4,message=("Name must be min of 4 character !!"))
	private String name;
	
    @NotEmpty
    @Size(min=4,message=("UserName must be min of 4 character !!"))
	private String username;
    
	@Email(message="Email address is not valid !!")
	private String email;
	
	@NotEmpty
	@Size(min=4,max=10,message=("Password must be min of 4 character and max of 10 character"))
	//@Pattern
	private String password;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
		
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", username=" + username + ", email=" + email + ", password="
				+ password + "]";
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
