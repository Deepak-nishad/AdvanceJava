package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

	//all basic crud operation methods automatically
}
