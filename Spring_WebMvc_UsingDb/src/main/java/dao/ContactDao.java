package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import entities.Contact;

public class ContactDao {
	@Autowired
	HibernateTemplate template;
	
	
//	@Transactional(readOnly=true)
	public List<Contact> getAll() {
		return template.loadAll(Contact.class);

	}
	@Transactional
	public int save(Contact ct) {
		return (int) template.save(ct);

	}
	
	
	
	

}
