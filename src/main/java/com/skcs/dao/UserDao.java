package com.skcs.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.skcs.entity.UserDetails;

public interface UserDao {
	public void setTemplate(HibernateTemplate template);
	public void saveEmployee(UserDetails u);
	public void updateEmployee(UserDetails u);
	public void deleteEmployee(UserDetails u);
	public UserDetails getById(int id);
	public List<UserDetails> getEmployees();
}
