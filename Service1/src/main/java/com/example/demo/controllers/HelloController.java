package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;

@RestController
@RequestMapping("/user")
public class HelloController {

	@GetMapping("/welcome")
	public String  welcome() {
		return "welcome user";
	}
	
	@GetMapping("/getuser")
	public User getuser() {
		User u = new User(1,"Bakul","Pune");
		return u;		
	}
}
