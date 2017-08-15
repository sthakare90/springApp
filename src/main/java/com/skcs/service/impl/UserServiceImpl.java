package com.skcs.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skcs.dao.UserDao;
import com.skcs.entity.UserDetails;
import com.skcs.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	Session session;

	@Autowired
	UserDao dao;
	
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public void saveUser(UserDetails u) {
		dao.saveUser(session, u);
	}

	public void updateUser(UserDetails u) {
		dao.updateUser(session, u);
	}

	public void deleteUser(UserDetails u) {
		dao.deleteUser(session, u);
	}

	public UserDetails getUserById(int id) {
		return dao.getUserById(session, id);
	}

	public List<UserDetails> getAllUsers(Session session) {
		return dao.getAllUsers(session);
	}

}
