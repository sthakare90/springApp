package com.skcs.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.skcs.dao.UserDao;
import com.skcs.entity.UserDetails;

@Repository
public class UserDaoImpl implements UserDao{
	
	HibernateTemplate template;  
	public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	}  
	
	//method to save employee
	@Transactional(readOnly=false)
	public void saveEmployee(UserDetails u){  
		System.out.println("Neme: "+u.getFirstName());
		
	    template.save(u);  
	    template.getSessionFactory().getCurrentSession().getTransaction().commit();
	}
	
	//method to update employee  
	public void updateEmployee(UserDetails u){  
	    template.update(u);  
	} 
	
	//method to delete employee  
	public void deleteEmployee(UserDetails u){  
	    template.delete(u);  
	}  
	
	//method to return one employee of given id  
	public UserDetails getById(int id){  
	    UserDetails u=(UserDetails)template.get(UserDetails.class,id);  
	    return u;  
	} 

	//method to return all employees  
	public List<UserDetails> getEmployees(){  
	    List<UserDetails> list=new ArrayList<UserDetails>();  
	    list=template.loadAll(UserDetails.class);  
	    return list;  
	}

}
