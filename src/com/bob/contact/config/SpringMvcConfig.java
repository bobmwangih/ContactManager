package com.bob.contact.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.bob.contact.dao.ContactDao;
import com.bob.contact.dao.ContactDaoImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.bob.contact")
public class SpringMvcConfig implements WebMvcConfigurer {
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:localhost:3306/contactdb");
		dataSource.setUsername("root");
		dataSource.setPassword("admin");
		return dataSource;
		
	}
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();       
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean
	public ContactDao getContactDao() {
		return new ContactDaoImpl(getDataSource());
	}
}
