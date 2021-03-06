package com.bob.contact.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	//handles the save form action
	@RequestMapping(value ="/save" ,method =RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Contact contact) {
		if(contact.getId()==0) {
			//for new contact
		contactDao.save(contact);
		}else {
			//the form was an edit request
			contactDao.update(contact);
		}
		return new ModelAndView("redirect:/");
		
	}
	
	//brings up the contactForm  view and captures the id to show
	@RequestMapping(value ="/edit",method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request,HttpServletRequest response) {
		int id = Integer.parseInt(request.getParameter("id"));
		Contact contact = contactDao.get(id);
		
		ModelAndView model = new ModelAndView("contactForm");
		model.addObject("contact", contact);
		return model;
		
	}
	
	//Captures the id in the RequestParam and deletes it
	@RequestMapping(value ="/delete", method = RequestMethod.GET)
	public ModelAndView deleteContact(@RequestParam int id) {
		contactDao.delete(id);
		return new ModelAndView("redirect:/");
		
	}
}
 	