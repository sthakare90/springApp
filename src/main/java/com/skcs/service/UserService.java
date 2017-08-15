package com.skcs.service;

import java.util.List;

import org.hibernate.Session;

import com.skcs.entity.UserDetails;

public interface UserService {
	
	public void setSession(Session session);
	public void saveUser(UserDetails u);
	public void updateUser(UserDetails u);
	public void deleteUser(UserDetails u);
	public UserDetails getUserById(int id);
	public List<UserDetails> getAllUsers(Session session);
	
}
