package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Contact;
import com.example.demo.repository.ContactRepository;

@Service
public class ContactService {
	@Autowired
	ContactRepository crepo;

	public List<Contact> getAllContact() {
		return crepo.findAll();
	}

	public Contact getOneContact(int id) {
		Contact ct = null;
		Optional<Contact> oc = crepo.findById(id);
		try {
			ct = oc.get();

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return ct;
	}
	
	public Contact save(Contact contact) {
		return crepo.save(contact);
		
	}
	
	

}
