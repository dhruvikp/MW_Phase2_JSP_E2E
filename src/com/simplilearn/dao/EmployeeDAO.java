package com.simplilearn.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.entity.Employee;
import com.simplilearn.util.HibernateUtil;

public class EmployeeDAO {

	
	public static void addEmployee(Employee e) {
		SessionFactory sf  = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(e);
		tx.commit();
		session.close();
	}
	
	public static List<Employee> listEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();
		
		employees = session.createQuery(" From Employee ").list();
		
		session.close();
		return employees;
	}
	
}
