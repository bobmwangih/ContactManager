package com.bob.contact.dao;

import java.util.List;

import com.bob.contact.model.Contact;

public interface ContactDao {

	public int save(Contact contact);
	public int update(Contact contact);
	public int delete(int id);
	public List<Contact> list();
	public Contact get(int id);
}
