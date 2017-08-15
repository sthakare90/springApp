import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.skcs.entity.UserDetails;
import com.skcs.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-test.xml"})
@EnableTransactionManagement
@Transactional(readOnly = false)
public class InsertTest {

	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	UserService userService;

	//@Test
	public void testInsertUser() {  
		Session session = sessionFactory.getCurrentSession();
		userService.setSession(session);
		UserDetails u=new UserDetails();  
		u.setUserId(11);  
		u.setFirstName("tip132");  
		u.setLastName("ABC");  
		u.setAddress1("gfghfdh");
		u.setAddress2("gfghfdh");
		userService.saveUser(u);
	}  

	//@Test
	public void testUpdateUser() {  
		Session session = sessionFactory.getCurrentSession();
		userService.setSession(session);
		UserDetails u=new UserDetails();  
		u.setUserId(11);  
		u.setFirstName("ABC145");  
		u.setLastName("ABC");  
		u.setAddress2("gfghfdh");
		userService.updateUser(u);
	}  

	//@Test
	public void testDeleteUser() {  
		Session session = sessionFactory.getCurrentSession();
		userService.setSession(session);
		UserDetails u=new UserDetails();  
		u.setUserId(11);  
		userService.deleteUser(u);
	}

	//@Test
	public void testGetUserById() {  
		Session session = sessionFactory.getCurrentSession();
		userService.setSession(session);
		UserDetails u = userService.getUserById(10);
		System.out.println(u);
	}

	@Test
	public void testGetAllUsers() {  
		Session session = sessionFactory.getCurrentSession();
		userService.setSession(session);
		List<UserDetails> list = userService.getAllUsers(session);
		for(UserDetails u: list)
			System.out.println(u);
	}

}
