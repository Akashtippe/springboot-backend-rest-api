package com.soringboot.Blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soringboot.Blog.payload.PostDto;
import com.soringboot.Blog.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {
	@Autowired
	private PostService postService;

	public PostController(PostService postService) {
		super();
		this.postService = postService;
	}

	//create blog post rest Api
	@PreAuthorize("hasRole('admin')")
	@PostMapping 
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
		
		return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
		
	}
	//get all post api
	@GetMapping
	public List<PostDto>getAllPosts(){
		return postService.getAllPosts();
	}
	//get post By Id
	@GetMapping("{id}")
	public ResponseEntity<PostDto> getPostById(@PathVariable(name="id")long id){
		return ResponseEntity.ok(postService.getPostById( id));
		
	}
	//update post rest api
	@PreAuthorize("hasRole('admin')")
	@PutMapping("{id}")
	public ResponseEntity<PostDto>updatePostBYId(@RequestBody PostDto postdto,@PathVariable(name="id")long id){
		return new ResponseEntity<>(postService.updatePostById(postdto, id),HttpStatus.OK);
		
	}
	@PreAuthorize("hasRole('admin')")
	@DeleteMapping("{id}")
	public ResponseEntity<String> deletePostById(@PathVariable(name="id")long id){
		postService.deletePostBYId(id);
		return  ResponseEntity.ok("post deleted successfully");
		
	}

}
