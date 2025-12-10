package com.example.demo.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Product;
import com.example.demo.repository.ProductRepositoy;

@Service
public class ProductService {
	@Autowired
	ProductRepositoy prepo;
	
	
	public List<Product>getAll(){
		return prepo.findAll();
	}
	
	public Product getOne(int id) {
		Product product = null;
		Optional<Product> op_cat = prepo.findById(id);
		try {
			product = op_cat.get();
		}
		catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		return product;
	}
	public Product save(Product p) {
		return prepo.save(p);
	}
	

}
