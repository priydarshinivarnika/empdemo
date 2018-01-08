package com.ust.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData {

	List<EmployeeData> empDatas = new ArrayList<EmployeeData>(10);

	public static void main(String[] args) {

		System.out.println("Hibernate Many to Many (XML mapping)");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		
		

		for (int i = 1; i <= 10; i++) {
			EmployeeData emp = new EmployeeData();
			emp.setFirstName("First" + i);
			emp.setLastName("Name");
			emp.setDepartment("Development");
			emp.getSkillDatas().add(new SkillData("Java"));
			emp.getSkillDatas().add(new SkillData("Sql"));
			session.persist(emp);
		}

		/*// queries all products
		List<EmployeeData> listEmployees = session.createQuery("from EmployeeData").list();
		for (EmployeeData aEmp : listEmployees) {
			String info = "FirstName: " + aEmp.getFirstName() + "\n";
			info += "LastName: " + aEmp.getLastName() + "\n";
			info += "Department:" + aEmp.getDepartment() + "\n";
			SkillData aDetail = (SkillData) aEmp.getSkillDatas();
			info += "Skill Name: " + aDetail.getName() + "\n";

			System.out.println(info);
		}
*/
		session.getTransaction().commit();
		System.out.println("successfully saved all the table");

		session.close();
		HibernateUtil.getSessionFactory().close();
	}

}
