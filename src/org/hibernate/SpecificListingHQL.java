package org.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.entity.Users;

public class SpecificListingHQL {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Users.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			 // Start transaction
			session.beginTransaction();
			
			List<Users> users= session.createQuery("from users where username = 'bader'"
					+ "OR last_name like '%a%nazi%'") //or you can write after where (first_name) coulom name like in database
					.getResultList();
			
			for (Users temp : users) {
				System.out.println(temp);
			}
			 // Commit the transaction 
			//session.getTransaction().commit();
			
		} finally {
			session.close(); 
			factory.close();
		}
	}

}
