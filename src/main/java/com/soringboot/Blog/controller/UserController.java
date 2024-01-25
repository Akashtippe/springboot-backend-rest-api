package com.soringboot.Blog.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soringboot.Blog.payload.PostDto;
import com.soringboot.Blog.payload.UserDto;
import com.soringboot.Blog.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//post - create post
	@PostMapping
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		return new ResponseEntity<>(this.userService.createUser(userDto),HttpStatus.CREATED);
		
	}
	//put -update api
	@PutMapping("/{id}")
	public ResponseEntity<UserDto>updateUser( @Valid @RequestBody UserDto userDto,@PathVariable(name="id") Long id){
		return new ResponseEntity<>(this.userService.updateUser(userDto, id),HttpStatus.OK);
		
	}
	//get -find by id
	@GetMapping("{id}")
	public ResponseEntity<UserDto>getUserById( @PathVariable(name=("id")) long id){
		return new ResponseEntity<>(this.userService.getUserById(id),HttpStatus.OK);
		
	}
	//delete- by id
	@DeleteMapping("{id}")
	public ResponseEntity<UserDto>deleteUser(@PathVariable(name="id") long id){
		this.userService.deleteUser(id);
		return new ResponseEntity(Map.of("message","user deleted successfully"),HttpStatus.OK);
		
	}
	//get all user
	//@GetMapping
	//public ResponseEntity<List<UserDto>>getAllUser(){
		//return new ResponseEntity<List<UserDto>>(this.userService.getAllUsers(),HttpStatus.OK);
		
	//}
	//get all post api
		@GetMapping("/")
		public List<UserDto>getAllUsers(){
			return userService.getAllUsers();
		}
}
