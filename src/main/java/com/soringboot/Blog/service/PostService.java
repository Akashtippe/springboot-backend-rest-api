package com.soringboot.Blog.service;



import java.util.List;

import com.soringboot.Blog.payload.PostDto;

public interface PostService {
	PostDto createPost(PostDto postDto);
	
	List <PostDto>getAllPosts();
	
	PostDto getPostById(Long id);
	
	PostDto updatePostById(PostDto postDto,long id);
	
	PostDto deletePostBYId(long id);
	
	
	
}
