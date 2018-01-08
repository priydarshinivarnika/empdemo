package com.ust.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SkillData {

	private int id;
	private String name;
	private EmployeeData empDatas;
	public SkillData() {
	}

	public SkillData(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EmployeeData getEmpDatas() {
		return empDatas;
	}

	public void setEmpDatas(EmployeeData empDatas) {
		this.empDatas = empDatas;
	}

	}
