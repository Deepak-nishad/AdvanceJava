package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Office;
import com.example.demo.services.OfficeService;

@RestController
@RequestMapping("/office")
public class OfficeController {

	@Autowired
	OfficeService cservice;
	
	@GetMapping("/getall")
	public List<Office>getAll(){
		return cservice.getAll();
	}
		
	@PutMapping("/updatephone")
	public int updateEmail(@RequestParam int oid,@RequestParam String phone) {
		return cservice.updatePhone(oid, phone);
	}
	
	
	@PostMapping("/save")
	public Office save(@RequestBody Office ct) {
		return cservice.save(ct);
		
	}
	

	@GetMapping("/getOne")
	public Office getAll(@RequestParam("oid") int id){

		return cservice.getOneContact(id);
	}
	
	@DeleteMapping("/delete/{oid}")
	public String delete(@PathVariable("oid") int id) {
		Office ct=cservice.getOneContact(id);
		if(ct!=null) {
			cservice.delete(ct);
			return "deleted succesfully";
		}
		else {
			return "Record not found";
			
		}
	}
	
//	@GetMapping("/getcount")
//	public int getCount() {	
//	}
	
}
	

	

