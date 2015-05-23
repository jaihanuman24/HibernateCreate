package com.om.hib.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.om.hib.dto.PersonDTO;

public class Tester {
	public static void main(String[] args){
		System.out.println("Create hibernate Starts");
		System.out.println("Create hibernate Starts");
		System.out.println("Create hibernate Starts");
		System.out.println("Create hibernate Starts");
		System.out.println("hibernate starts----------------===============================================");
		
		
		PersonDTO personDTO=new PersonDTO();
		personDTO.setName("om");
		personDTO.setPlace("bangalore");
		Configuration configuration=new Configuration();
		configuration.configure();
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		try{
			transaction.begin();
			session.save(personDTO);
			transaction.commit();
		}catch(HibernateException exception){
			transaction.rollback();
			exception.printStackTrace();
		}finally{
			session.close();
		}
	}

}
