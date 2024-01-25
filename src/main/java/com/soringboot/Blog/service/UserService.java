package com.soringboot.Blog.service;

import java.util.List;

import com.soringboot.Blog.payload.UserDto;

public interface UserService {
	
 UserDto createUser(UserDto userDto);
 
 UserDto updateUser(UserDto userDto,long id);
 
 UserDto getUserById(long id);
 
 List<UserDto>getAllUsers();
 
 void deleteUser(long id);
 
 
}
