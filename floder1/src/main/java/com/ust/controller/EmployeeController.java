package com.ust.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ust.model.EmployeeData;

@Controller
@RequestMapping("/details")
public class EmployeeController {


	// Map to store details of employees
	Map<Integer, EmployeeData> empData = new HashMap<Integer, EmployeeData>();

	
	@RequestMapping(value = EmpUriConstants.DUMMY_EMP, method = RequestMethod.GET)
	public @ResponseBody EmployeeData getDummyEmployee() {

		EmployeeData emp = new EmployeeData();
		emp.setFirstName("Varnika");
		emp.setId(1);
		emp.setLastName("Priydarshini");
		empData.put(1, emp);
		return emp;
	}

	@RequestMapping(value = EmpUriConstants.CREATE_EMP, method = RequestMethod.POST)
	public @ResponseBody EmployeeData createEmployee(@RequestBody EmployeeData emp) {
		empData.put(emp.getId(), emp);
		return emp;
	}
	@RequestMapping(value = EmpUriConstants.GET_EMP, method = RequestMethod.GET)
	public @ResponseBody EmployeeData getEmployee(@PathVariable("id") int empId) {
		System.out.println("Fetching E with id " + empId);
		return empData.get(empId);

	}

	@RequestMapping(value = EmpUriConstants.GET_ALL_EMP, method = RequestMethod.GET)
	public @ResponseBody List<EmployeeData> getAllEmployees() {

		List<EmployeeData> emps = new ArrayList<EmployeeData>();
		Set<Integer> empIdKeys = empData.keySet();
		for (Integer i : empIdKeys) {
			emps.add(empData.get(i));
		}
		return emps;
	}

	@RequestMapping(value = EmpUriConstants.UPDATE_EMP, method = RequestMethod.PUT)
	public @ResponseBody EmployeeData updateEmployee(@PathVariable("id") int empId) {

		EmployeeData emp = empData.get(empId);
		empData.put(emp.getId(), emp);
		return emp;
		
		

	}

	@RequestMapping(value = EmpUriConstants.DELETE_EMP, method = RequestMethod.PUT)
	public @ResponseBody EmployeeData deleteEmployee(@PathVariable("id") int empId) {

		EmployeeData emp = empData.get(empId);
		return empData.remove(empId);
	}

}
