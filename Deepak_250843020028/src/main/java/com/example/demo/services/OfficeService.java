package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Office;
import com.example.demo.reposity.OfficeRepositry;


@Service
public class OfficeService {
	@Autowired
	OfficeRepositry crepo;

	public List<Office> getAll() {
		return crepo.findAll();
	}
	
	public Office save(Office office) {
		return crepo.save(office);
		
	}
	
	public Office getOneContact(int id) {
		Office ct = null;
		Optional<Office> oc = crepo.findById(id);
		try {
			ct = oc.get();

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return ct;
	}

	public void delete(Office ot) {
		crepo.delete(ot);
		
	}
	
	public int updatePhone(int oid, String phone) {
		return crepo.updatePhone(oid, phone);
	}
//	public int getCount(String country) {
//		return crepo.countByCountry(country);
//	}
	
}
