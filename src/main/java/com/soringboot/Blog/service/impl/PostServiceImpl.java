package com.soringboot.Blog.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soringboot.Blog.entity.Post;
import com.soringboot.Blog.entity.User;
import com.soringboot.Blog.entity.Category;
import com.soringboot.Blog.exception.ResourceNotFoundException;
import com.soringboot.Blog.payload.PostDto;
import com.soringboot.Blog.repository.CategoryRepository;
import com.soringboot.Blog.repository.PostRepository;
import com.soringboot.Blog.repository.UserRepository;
import com.soringboot.Blog.service.PostService;

@Service
public class PostServiceImpl implements PostService{
	@Autowired
	private PostRepository postRepository;
	
	private ModelMapper mapper;
	
	
	
	

	public PostServiceImpl(PostRepository postRepository, ModelMapper mapper) {
		super();
		this.postRepository = postRepository;
		this.mapper = mapper;
	}

	@Override
	public PostDto createPost(PostDto postDto) {
		
		// convert DTO to entity
		Post post=mapToEntity(postDto);
		Post newPost=postRepository.save(post);
		 

		
		
		// convert entity to DTO
	//	PostDto postResponse= mapToDto(newPost);
		return mapper.map(newPost,PostDto.class) ;
	}

//GetAll Query
	@Override
	public List<PostDto> getAllPosts(){
		List<Post>posts=postRepository.findAll();
		return posts.stream().map(post ->mapToDto(post)).collect(Collectors.toList());
		
	}
	 //convert entity into DTo
	private PostDto mapToDto(Post post) {
		PostDto posDto=mapper.map(post, PostDto.class);
		
		//PostDto postDto=new PostDto();
	//	postDto.setId(post.getId());
		//postDto.setDescription(post.getDescription());
	//	postDto.setContent(post.getContent());
		//postDto.setTitle(post.getTitle());
		return posDto;
		
	}
	//convert DTO to entity
	
	private Post mapToEntity(PostDto postDto) {
		Post post= mapper.map(postDto, Post.class);
	
		
//		post.setTitle(postDto.getTitle());
	//	post.setDescription(postDto.getDescription());
		//post.setContent(postDto.getContent());
		
		return post;
		
	}
//findById query
	@Override
	public PostDto getPostById(Long id) {
		Post post=postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
		return mapToDto(post);
	}
// update BY id
	@Override
	public PostDto updatePostById(PostDto postDto, long id) {
		//get post by id from the database
		Post post=postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
		
		post.setContent(postDto.getContent());
		
		post.setTitle(postDto.getTitle());
		
		Post updatePostById=postRepository.save(post);
		
		return mapToDto(updatePostById);
	}

	@Override
	public PostDto deletePostBYId(long id) {
		// first retrive the post by Id
		Post post=postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
		postRepository.delete(post);
		
		return null;
	}

	
}
