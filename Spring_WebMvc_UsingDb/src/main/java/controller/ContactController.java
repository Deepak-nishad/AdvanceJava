package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.ContactDao;
import entities.Contact;

@Controller
public class ContactController {
	@Autowired
	ContactDao cdao;

	@RequestMapping("/all")
	public ModelAndView getAll() {
		List<Contact> clist = cdao.getAll();
		for(Contact c: clist) {
			System.out.println(c);
		}
		return new ModelAndView("allcontacts", "contactlist", clist);

	}
	
	@RequestMapping("/getContact")
	public ModelAndView showForm() {
		return new ModelAndView("contactform", "ct", new Contact());
		
	}
	
	@RequestMapping("/insertContact")
	public ModelAndView insertContact(@ModelAttribute("ct")Contact contact) {
		int insertedid=cdao.save(contact);
		System.out.println(insertedid);
		return new ModelAndView("msg","id",insertedid);
		
	}

}
