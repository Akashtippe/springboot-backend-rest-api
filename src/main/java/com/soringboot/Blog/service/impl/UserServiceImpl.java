package com.soringboot.Blog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soringboot.Blog.entity.User;
import com.soringboot.Blog.exception.ResourceNotFoundException;
import com.soringboot.Blog.payload.UserDto;
import com.soringboot.Blog.repository.UserRepository;
import com.soringboot.Blog.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user=this.dtoToUser(userDto);
		User savedUser=this.userRepository.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, long id) {
		User user=this.userRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("User", "id", id));
		
		user.setEmail(userDto.getEmail());
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		User updareUser=this.userRepository.save(user);
		UserDto userDto1=this.userToDto(updareUser);
		return userDto1;
	}

	@Override
	public UserDto getUserById(long id) {
		User user=this.userRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("User", "id", id));
		
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User>users=this.userRepository.findAll();
		List<UserDto>userDtos=users.stream().map(user ->this.userToDto(user))
				.collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(long id) {
		User user=this.userRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("User", "id", id));
		this.userRepository.delete(user);
		
	}
  private User dtoToUser(UserDto userDto) {
	  User user=this.modelMapper.map(userDto, User.class);
//	  User user=new User();
//	  user.setEmail(userDto.getEmail());
//	  user.setId(userDto.getId());
//	  user.setName(userDto.getName());
//	  user.setPassword(userDto.getPassword());
	 // user.setUsername(userDto.getUsername());
	return user;
	  
  }
  private UserDto userToDto(User user) {
	  UserDto userDto=this.modelMapper.map(user,UserDto.class);
//	  UserDto userDto=new UserDto();
//	  userDto.setEmail(user.getEmail());
//	  userDto.setId(user.getId());
//	  userDto.setName(user.getName());
//	  userDto.setPassword(user.getPassword());
	//  userDto.setUsername(user.getUsername());
	return userDto;
	  
  }
}
