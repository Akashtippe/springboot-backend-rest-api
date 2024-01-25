package com.soringboot.Blog.payload;

import java.util.Date;

import com.soringboot.Blog.entity.Category;
import com.soringboot.Blog.entity.User;

import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class PostDto {
	private Long id;
	private String title ;
	
	private String content ;
	
	
	
	
	
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getPostid() {
		return id;
	}
	public void setPostid(Long postid) {
		this.id = postid;
	}
	
	
	
	
	
	

}
