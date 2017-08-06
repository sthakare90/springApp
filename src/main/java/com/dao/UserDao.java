package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.entity.UserDetails;

public class UserDao {
	
	HibernateTemplate template;  
	public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	}  
	
	//method to save employee  
	public void saveEmployee(UserDetails u){  
	    template.save(u);  
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
