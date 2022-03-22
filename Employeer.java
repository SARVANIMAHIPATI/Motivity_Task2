package com.motivity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;

@Table(name="Employeer")
@Entity

public class Employeer {
	@Id
	@Column(name="employer_id")
	 private int employer_id;
	@Column(name="employer_name")
     private String employer_name;
	@Column(name="department")
     private String department;
	@Column(name="mobile")
     private long mobile;
	
	
	@OneToMany(targetEntity = Employee.class, cascade=CascadeType.ALL, mappedBy="employer")
	
	
	private List<Employee> employee = new ArrayList<Employee>();


	public int getEmployer_id() {
		return employer_id;
	}


	public void setEmployer_id(int employer_id) {
		this.employer_id = employer_id;
	}


	public String getEmployer_name() {
		return employer_name;
	}


	public void setEmployer_name(String employer_name) {
		this.employer_name = employer_name;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public long getMobile() {
		return mobile;
	}


	public void setMobile(long mobile) {
		this.mobile = mobile;
	}


	public List<Employee> getEmployee() {
		return employee;
	}


	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	
	
	
     
}