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
import com.example.demo.entities.ProductDummy;
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
	
	
	
	// Save new child with new master
		@PostMapping("/save")
		public Product save(@RequestBody Product p) {
			return pservice.save(p);
		}
		
	@PostMapping("/saveProduct")
	public Product save1(@RequestBody ProductDummy p) {
		//id - entity instance
				Category cat = cservice.getOne(p.getP_id());
				Product pr = new Product();
				pr.setP_name(p.getP_name());
				pr.setP_description(p.getP_description());
				pr.setP_price(p.getP_price());
				pr.setCategory(cat);
				return pservice.save(pr);
	}
	
	

}
