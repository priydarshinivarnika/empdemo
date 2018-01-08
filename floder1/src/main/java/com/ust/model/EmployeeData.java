package com.ust.model;

import java.util.HashSet;

import java.util.Set;

public class EmployeeData {

	private int id;
	private String firstName, lastName, department;
	private Set<SkillData> skillDatas = new HashSet<SkillData>(0);

	public EmployeeData() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Set<SkillData> getSkillDatas() {
		return skillDatas;
	}

	public void setSkillDatas(Set<SkillData> skills) {
		this.skillDatas = skills;
	}

}
