package com.soringboot.Blog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soringboot.Blog.entity.Category;
import com.soringboot.Blog.exception.ResourceNotFoundException;
import com.soringboot.Blog.payload.CategoryDto;
import com.soringboot.Blog.payload.UserDto;
import com.soringboot.Blog.repository.CategoryRepository;
import com.soringboot.Blog.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ModelMapper modelMapper;
	
//post =create
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category category=this.dtoToCategory(categoryDto);
		Category saveCategory=this.categoryRepository.save(category);
		return this.CategoryToDto(saveCategory);
	}
//put =update
	@Override
	public CategoryDto updateCategoryById(CategoryDto categoryDto, long id) {
		Category category=this.categoryRepository.findById(id).orElseThrow(() ->
		new ResourceNotFoundException("Category", "id", id));
		
		category.setTitle(categoryDto.getTitle());
		category.setDescription(categoryDto.getDescription());
		Category updateCategory=this.categoryRepository.save(category);
		CategoryDto categoryDto1=this.CategoryToDto(updateCategory);
		
		
		return categoryDto1;
	}
//get All Category
	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category>categorys=this.categoryRepository.findAll();
		List<CategoryDto>categoryDtos=categorys.stream().map(category ->this.CategoryToDto(category))
				.collect(Collectors.toList());
		return categoryDtos;
	}
//find by Id get
	@Override
	public CategoryDto findCategoryById(long id) {
		Category category=this.categoryRepository.findById(id).orElseThrow(() ->
		new ResourceNotFoundException("Category", "id", id));
		
		return this.CategoryToDto(category);
	}

	@Override
	public CategoryDto deleteCategoryById(long id) {
		Category category=this.categoryRepository.findById(id).orElseThrow(() ->
		new ResourceNotFoundException("Category", "id", id));
		this.categoryRepository.delete(category);
		return null;
	}
	
	private Category dtoToCategory(CategoryDto categoryDto) {
		Category category=this.modelMapper.map(categoryDto, Category.class);
		return category;
		
	}
	
	private CategoryDto CategoryToDto(Category category) {
		CategoryDto categoryDto=this.modelMapper.map(category, CategoryDto.class);
		return categoryDto;
		
	}
	

}
