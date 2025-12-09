package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Contact;
import com.example.demo.services.ContactService;

@RestController
public class ContactControllers {
	@Autowired
	ContactService cservice;
	
	@GetMapping("/all")
	public List<Contact>getAll(){
		return cservice.getAllContact();
	}
	
	// cid is same in while sending query
	@GetMapping("/getOne")
	public Contact getAll(@RequestParam("cid") int id){

		return cservice.getOneContact(id);
	}
	
	@PostMapping("/save")
	public Contact save(@RequestBody Contact ct) {
		return cservice.save(ct);
		
	}

}
