package com.bob.contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bob.contact.dao.ContactDao;
import com.bob.contact.model.Contact;

@Controller
public class MainController {
	@Autowired
	private ContactDao contactDao;
	
	@RequestMapping("/")
	public ModelAndView listContact(ModelAndView model) {
		List<Contact> listContact = contactDao.list();
		model.addObject("listContact", listContact);
		model.setViewName("index");
		return model;
	}
	
}
 	