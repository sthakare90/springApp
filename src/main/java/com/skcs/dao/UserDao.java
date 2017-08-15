package com.skcs.dao;

import java.util.List;

import org.hibernate.Session;

import com.skcs.entity.UserDetails;

public interface UserDao {
	public void saveUser(Session session, UserDetails u);
	public void updateUser(Session session, UserDetails u);
	public void deleteUser(Session session, UserDetails u);
	public UserDetails getUserById(Session session, int id);
	public List<UserDetails> getAllUsers(Session session);
}
