package com.soringboot.Blog.service;

import java.util.List;

import com.soringboot.Blog.payload.CategoryDto;

public interface CategoryService {
	
	//create
	CategoryDto createCategory(CategoryDto categoryDto);
	
	//update
	CategoryDto updateCategoryById(CategoryDto categoryDto,long catid);
	
	//get All
	List<CategoryDto>getAllCategory();
	
	//findby id=get
	CategoryDto findCategoryById(long catid);
	
	//delete
	CategoryDto deleteCategoryById(long catid);
	
	

}
