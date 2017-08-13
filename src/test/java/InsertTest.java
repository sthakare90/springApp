import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
import org.springframework.transaction.annotation.Transactional;

import com.skcs.dao.UserDao;
import com.skcs.entity.UserDetails;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-test.xml"})
@EnableTransactionManagement
/*@TransactionConfiguration(transactionManager = "transactionManager")
@Transactional(readOnly = false)*/
public class InsertTest {
	@Autowired
	UserDao dao;

	@Test
	@Transactional(readOnly=false)
	public void testInsert() {  

		Resource r=new ClassPathResource("applicationContext-test.xml"); 
		//Resource r = new FileSystemResource("C:\\Users\\Acer\\Desktop\\Proj\\SpringMVC\\src\\applicationContext.xml");
		BeanFactory factory=new XmlBeanFactory(r);  
		HibernateTemplate template=(HibernateTemplate)factory.getBean("template");
		SessionFactory sessionFactory=(SessionFactory)factory.getBean("mysessionFactory");
		Session session = sessionFactory.openSession();
		Transaction tx = session.getTransaction();
		try{

			dao.setTemplate(template);
			tx.begin();
			UserDetails e=new UserDetails();  
			e.setUserId(5);  
			e.setFirstName("riya");  
			e.setLastName("ABC");  
			e.setAddress1("gfghfdh");
			e.setAddress2("gfghfdh");

			//dao.saveEmployee(e);

			session.saveOrUpdate(e);
			tx.commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			session.close();
		}

		System.out.println(dao.getById(4).getFirstName());

	}  

}
