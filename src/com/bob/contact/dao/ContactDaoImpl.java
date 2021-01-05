package com.bob.contact.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.bob.contact.model.Contact;

public class ContactDaoImpl implements ContactDao {

	private JdbcTemplate jdbcTemplate;
	
	public ContactDaoImpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Override
	public int save(Contact c) {
		String sql = "Insert into contact (name,email,address,phone) values(?,?,?,?)";
		return jdbcTemplate.update(sql, c.getName(),c.getEmail(),c.getAddress(),c.getPhone()); //returns the number of rows inserted
	}

	@Override
	public int update(Contact c) {
		String sql = "Update contact set  name =?,email =?,address=?,phone=? where contact_id=?";
		return jdbcTemplate.update(sql,c.getName(),c.getEmail(),c.getAddress(),c.getPhone(),c.getId());
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Contact> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
 