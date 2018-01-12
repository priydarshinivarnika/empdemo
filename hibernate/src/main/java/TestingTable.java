
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;

import com.ust.model.EmployeeEntity;
import com.ust.model.SkillEntity;
import com.ust.utility.HibernateUtil;

public class TestingTable {

	public static void main(String[] args)

	{

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		SkillEntity skill1 = new SkillEntity();
		skill1.setName("Java");

		SkillEntity skill2 = new SkillEntity();
		skill2.setName("SQL");

		EmployeeEntity emp1 = new EmployeeEntity();

		emp1.setEmail("abc@mail.com");
		emp1.setFirstName("First");
		emp1.setLastName("Name");
		emp1.setDepartment("Physics");

		EmployeeEntity emp2 = new EmployeeEntity();

		emp2.setEmail("@mail.com");
		emp2.setFirstName("Second");
		emp2.setLastName("Name");
		emp2.setDepartment("Chemistry");

		Set<SkillEntity> skills = new HashSet<SkillEntity>();
		skills.add(skill1);
		skills.add(skill2);

		emp1.setSkills(skills);
		//emp2.setSkills(skills);

		// Save Employee
		session.save(emp1);
		session.save(emp2);
		session.getTransaction().commit();
		HibernateUtil.shutdown();

	}

}
