package com.soringboot.Blog.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soringboot.Blog.entity.Category;
import com.soringboot.Blog.entity.Post;
import com.soringboot.Blog.entity.User;

public interface PostRepository extends JpaRepository<Post, Long>{
	
	/*Optional<Post>findByUsername(String username);
	Optional<Post> findByPassword(String password);
	Optional<Post> findByRole(String role);
	Optional<Post> findByEmail(String email);
	*/
	

	
	

}
 