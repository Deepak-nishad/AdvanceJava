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
import com.example.demo.entities.Product;
import com.example.demo.services.CategoryService;
import com.example.demo.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductService pservice;
	@Autowired
	CategoryService cservice;
	
	@GetMapping("/getAll")
	public List<Product>getAll(){
		return pservice.getAll();
	}
	
	@GetMapping("/getOne")
	public Product getOne(@RequestParam int id) {
		return pservice.getOne(id);
	}
	
	@PostMapping("/save")
	public Product save(@RequestBody Product p) {
		//System.out.print("all done");
		int cid = p.getCategory().getC_id();
		Category cat = cservice.getOne(cid);
		p.setCategory(cat);
		return pservice.save(p);
	}
	
	

}
