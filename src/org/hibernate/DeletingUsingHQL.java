package org.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.entity.Users;

public class DeletingUsingHQL {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Users.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			 // Start transaction
			session.beginTransaction();
			session.createQuery("delete from users where user_id = 1").executeUpdate();//update password coulomn 
			//session.createQuery("update users set password = '0000' where first_name='bader'").executeUpdate();//update password coulomn 
			
			 session.getTransaction().commit();
			
		} finally {
			session.close(); 
			factory.close();
		}
	}

}
