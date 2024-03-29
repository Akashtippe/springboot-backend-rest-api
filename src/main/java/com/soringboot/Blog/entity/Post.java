package com.soringboot.Blog.entity;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(
		name="posts",uniqueConstraints= {@UniqueConstraint(columnNames= {"title"})})

public class Post {
	@Id
	@GeneratedValue(
			strategy=GenerationType.IDENTITY)
	
	private Long id;

	private String title ;

	private String content;



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
	
	
	//@OneToMany(mappedBy="post",cascade=CascadeType.ALL,orphanRemoval = true)
	//private Set<Comment>comments=new HashSet();
	
	
	


	
	

	

}
