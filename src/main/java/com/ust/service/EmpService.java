package com.ust.service;

import java.util.List;
import com.ust.model.EmployeeEntity;

public interface EmpService {

	 EmployeeEntity findById(long id);
     
	 EmployeeEntity findByName(String name);
	     
	    void saveEmployee(EmployeeEntity emp);
	     
	    void updateEmployee(EmployeeEntity emp);
	     
	    void deleteEmployeeById(long id);
	 
	    List<EmployeeEntity> findAllEmployees(); 
	     
	    void deleteAllEmployees();
	     
	    public boolean isEmployeeExist(EmployeeEntity emp);

}
