package com.bob.contact.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.bob.contact.model.Contact;

public class ContactDaoImpl implements ContactDao {

	private JdbcTemplate jdbcTemplate;

	public ContactDaoImpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public int save(Contact c) {
		String sql = "Insert into contact (name,email,address,phone) values(?,?,?,?)";
		return jdbcTemplate.update(sql, c.getName(), c.getEmail(), c.getAddress(), c.getPhone()); // returns the number
																									// of rows inserted
	}

	@Override
	public int update(Contact c) {
		String sql = "Update contact set  name =?,email =?,address=?,phone=? where contact_id=?";
		return jdbcTemplate.update(sql, c.getName(), c.getEmail(), c.getAddress(), c.getPhone(), c.getId());
	}

	@Override
	public int delete(int id) {
		String sql = "Delete from  contact where contact_id =" + id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<Contact> list() {
		String sql = "Select * from contact";

		RowMapper<Contact> rowMapper = new RowMapper<Contact>() {

			@Override
			public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
				int id = rs.getInt("contact_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				return new Contact(id, name, email, address, phone);
			}

		};
		return jdbcTemplate.query(sql, rowMapper);
	} 

	@Override
	public Contact get(int id) {
		String sql = "Select * from contact where contact_id =" + id;

		ResultSetExtractor<Contact> extractor = new ResultSetExtractor<Contact>() {

			@Override
			public Contact extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					String name = rs.getString("name");
					String email = rs.getString("email");
					String address = rs.getString("address");
					String phone = rs.getString("phone");
					return new Contact(id, name, email, address, phone);
				}
				return null;
			}

		};
		return jdbcTemplate.query(sql, extractor);
	}

}
