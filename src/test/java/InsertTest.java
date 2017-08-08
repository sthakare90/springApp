import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.skcs.dao.UserDao;
import com.skcs.entity.UserDetails;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-test.xml"})
@EnableTransactionManagement
/*@TransactionConfiguration(transactionManager = "transactionManager")*/
//@Transactional(readOnly = false)
public class InsertTest {
	@Autowired
    UserDao dao;
	
	@Test
	public void testInsert() {  
	      
	    Resource r=new ClassPathResource("applicationContext-test.xml"); 
		//Resource r = new FileSystemResource("C:\\Users\\Acer\\Desktop\\Proj\\SpringMVC\\src\\applicationContext.xml");
	    BeanFactory factory=new XmlBeanFactory(r);  
	      
	    HibernateTemplate template=(HibernateTemplate)factory.getBean("template");
	    
	    dao.setTemplate(template);
	      
	    UserDetails e=new UserDetails();  
	    e.setUserId("fdgdgd");  
	    e.setFirstName("varun");  
	    e.setLastName("ABC");  
	    e.setAddress1("gfghfdh");
	    e.setAddress2("gfghfdh");
	      
	    dao.saveEmployee(e);  
	      
	}  

}
