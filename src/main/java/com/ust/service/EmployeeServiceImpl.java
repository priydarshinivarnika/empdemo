package com.ust.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import com.ust.model.EmployeeEntity;
import com.ust.model.SkillEntity;
import com.ust.utility.HibernateUtil;

@Service("empService")
public class EmployeeServiceImpl {

	private static List<EmployeeEntity> emps = new ArrayList<EmployeeEntity>(10);

	static {

		System.out.println("Hibernate Many to Many (XML mapping)");
		emps = populateDummyEmployees();
	}

	public static List<EmployeeEntity> populateDummyEmployees() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		for (int i = 1; i <= 10; i++) {
			EmployeeEntity emp = new EmployeeEntity();
			emp.setFirstName("First" + i);
			emp.setLastName("Name");
			emp.setDepartment("Development");
			emp.getSkillDatas().add(new SkillEntity("Java"));
			emp.getSkillDatas().add(new SkillEntity("Sql"));
			session.persist(emp);
		}
		session.getTransaction().commit();
		System.out.println("successfully saved all the table");

		session.close();
		HibernateUtil.getSessionFactory().close();
		return emps;
	}
	 public List<EmployeeEntity> findAllEmployees() {
	        return emps;
	    }

	 public EmployeeEntity findById(long id) {
	        for(EmployeeEntity emp : emps){
	            if(emp.getId() == id){
	                return emp;
	            }
	        }
	        return null;
	    }
}
