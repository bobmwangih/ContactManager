package com.bob.contact.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.bob.contact.model.Contact;

class ContactDaoTest {
	private DriverManagerDataSource dataSource;
	private ContactDao dao;
	
	@BeforeEach
	public void beforeEach() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb");
		dataSource.setUsername("root");
		dataSource.setPassword("admin");
		
		dao = new ContactDaoImpl(dataSource);
	}
	
	@Test
	void testSave() {	
		Contact contact = new Contact("Bob","bob@gmail.com","Kumasi lane","0121");
		int result = dao.save(contact);
		assertTrue(result > 0);
	}

	@Test
	void testUpdate() {
		Contact contact = new Contact(2,"master","bobby@gmail.com","panga lane","45592");
		int result = dao.update(contact);
		assertTrue(result > 0);
	}

	@Test
	void testDelete() {
		int id =1;
		int result = dao.delete(id);
		assertTrue(result >  0);
	}

	@Test
	void testList() {
		fail("Not yet implemented");
	}

	@Test
	void testGet() {
		 int id =3;
		 Contact contact = dao.get(id);
		 assertNotNull(contact);
		 System.out.println(contact);
	}

}
