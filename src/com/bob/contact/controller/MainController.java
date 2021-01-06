package com.bob.contact.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bob.contact.dao.ContactDao;
import com.bob.contact.model.Contact;

@Controller
public class MainController {
	@Autowired
	private ContactDao contactDao;
	
	//displaying contacts
	@RequestMapping("/")
	public ModelAndView listContact(ModelAndView model) {
		List<Contact> listContact = contactDao.list();
		model.addObject("listContact", listContact);
		model.setViewName("index");
		return model;
	}
	
	//redirecting to add/edit new contact
	@RequestMapping(value ="/New", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) { 
		Contact newContact = new Contact();
		model.addObject("contact", newContact);
		model.setViewName("contactForm");
		return model;
	}
	
	@RequestMapping(value ="/save" ,method =RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Contact contact) {
		if(contact.getId()==0) {
		contactDao.save(contact);
		}else {
			contactDao.update(contact);
		}
		return new ModelAndView("redirect:/");
		
	}
	
	@RequestMapping(value ="/edit",method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request,HttpServletRequest response) {
		int id = Integer.parseInt(request.getParameter("id"));
		Contact contact = contactDao.get(id);
		
		ModelAndView model = new ModelAndView("contactForm");
		model.addObject("contact", contact);
		return model;
		
	}
}
 	