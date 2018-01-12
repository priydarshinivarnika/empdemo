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

import com.ust.model.EmployeeEntity;
import com.ust.service.EmployeeServiceImpl;

@Controller
@RequestMapping("/details")
public class EmployeeController {

	// Map to store details of employees
	Map<Integer, EmployeeEntity> empData = new HashMap<Integer, EmployeeEntity>();

	@RequestMapping(value = EmpUriConstants.DUMMY_EMP, method = RequestMethod.GET)
	public @ResponseBody EmployeeServiceImpl getDummyEmployee() {

		EmployeeServiceImpl empImpl = new EmployeeServiceImpl();
		EmployeeServiceImpl.populateDummyEmployees();

		return empImpl;
	}

	@RequestMapping(value = EmpUriConstants.CREATE_EMP, method = RequestMethod.POST)
	public @ResponseBody String createEmployee(@RequestBody EmployeeEntity emp) {
		EmployeeServiceImpl.populateDummyEmployees();
		return "ok";

		/*
		 * empData.put(emp.getId(), emp); return emp;
		 */
	}

	@RequestMapping(value = EmpUriConstants.GET_EMP, method = RequestMethod.GET)
	public @ResponseBody EmployeeEntity getEmployee(@PathVariable("id") int empId) {
		System.out.println("Fetching E with id " + empId);
		return empData.get(empId);

	}

	@RequestMapping(value = EmpUriConstants.GET_ALL_EMP, method = RequestMethod.GET)
	public @ResponseBody List<EmployeeEntity> getAllEmployees() {

		List<EmployeeEntity> emps = new ArrayList<EmployeeEntity>();
		Set<Integer> empIdKeys = empData.keySet();
		for (Integer i : empIdKeys) {
			emps.add(empData.get(i));
		}
		return emps;
	}

	/*
	 * @RequestMapping(value = EmpUriConstants.UPDATE_EMP, method =
	 * RequestMethod.PUT) public @ResponseBody EmployeeData
	 * updateEmployee(@PathVariable("id") int empId) {
	 * 
	 * EmployeeData emp = empData.get(empId); empData.put(emp.getId(), emp); return
	 * emp;
	 * 
	 * 
	 * 
	 * }
	 */
	@RequestMapping(value = EmpUriConstants.UPDATE_EMP, method = RequestMethod.PUT)
	public @ResponseBody EmployeeEntity updateEmployee(@PathVariable("id") int empId, @RequestBody EmployeeEntity emp) {

		EmployeeEntity emps = empData.get(empId);
		empData.put(emp.getEmployeeId(), emps);
		return emp;
	

	}

	@RequestMapping(value = EmpUriConstants.DELETE_EMP, method = RequestMethod.PUT)
	public @ResponseBody EmployeeEntity deleteEmployee(@PathVariable("id") int empId) {

		EmployeeEntity emp = empData.get(empId);
		return empData.remove(emp);
	}

}
