package com.skcs.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.skcs.dao.UserDao;
import com.skcs.entity.UserDetails;

@Repository
public class UserDaoImpl implements UserDao{

	//method to save user
	@Transactional(readOnly=false)
	public void saveUser(Session session, UserDetails u){ 
		Transaction tx = session.getTransaction();
		try{
			session.saveOrUpdate(u);
			tx.commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}

	//method to update user  
	public void updateUser(Session session, UserDetails u){  
		Transaction tx = session.getTransaction();
		try{
			session.update(u);
			tx.commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	} 

	//method to delete user  
	public void deleteUser(Session session, UserDetails u){  
		Transaction tx = session.getTransaction();
		try{
			session.delete(u);
			tx.commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}  

	//method to return one user of given id  
	public UserDetails getUserById(Session session, int id){  
		UserDetails u = null;
		try{
			u=(UserDetails)session.get(UserDetails.class,id);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return u;  
	} 

	//method to return all users  
	public List<UserDetails> getAllUsers(Session session){  
		List<UserDetails> list=new ArrayList<UserDetails>();  
		try{
			list = (List<UserDetails>)(session.createCriteria(UserDetails.class).list());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;  
	}

}
