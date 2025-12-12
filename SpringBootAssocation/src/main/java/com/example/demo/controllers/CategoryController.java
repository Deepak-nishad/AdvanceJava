package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Category;
import com.example.demo.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	CategoryService cservice;

	@GetMapping("/getAll")
	public List<Category> getAll(){
		return  cservice.getAll();
		
	}
	
	@GetMapping("/getOne")
	public Category getOne(@RequestParam int id){
		return  (Category) cservice.getOne(id);
		
	}
	
	// Save new Master with new child
	@PostMapping("/save")
	public Category save(@RequestBody Category category) {
		return cservice.save(category);
	}
	
}
