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

import com.soringboot.Blog.payload.CategoryDto;
import com.soringboot.Blog.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	//create =postmapping
	@PostMapping
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
		return new ResponseEntity<>(this.categoryService.createCategory(categoryDto),HttpStatus.CREATED);
		
	}
//update=putmapping
	@PutMapping("{id}")
	public ResponseEntity<CategoryDto>updateCategory(@RequestBody CategoryDto categoryDto,@PathVariable Long id){
		return new ResponseEntity<>(this.categoryService.updateCategoryById(categoryDto,id),HttpStatus.OK);
		
	}
	
	//getAll=getmapping
	@GetMapping
	public List<CategoryDto> getAllCategory(){
		return categoryService.getAllCategory();
		
	}
	//findById=getmapping
	@GetMapping("{id}")
	public ResponseEntity<CategoryDto> findCategoryById(@PathVariable long id){
		return new ResponseEntity<>(this.categoryService.findCategoryById(id),HttpStatus.OK);
		
	}
	//delete by id =deletemapping
	@DeleteMapping("{id}")
	public ResponseEntity<CategoryDto>deleteCategoryById(@PathVariable  long id){
		this.categoryService.deleteCategoryById(id);
		return new ResponseEntity(Map.of("message","Category deleted successfully"),HttpStatus.OK);
	}
}
