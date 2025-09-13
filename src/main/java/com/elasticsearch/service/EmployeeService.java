package com.elasticsearch.service;

import java.util.List;

import com.elasticsearch.enity.Employee;

public interface EmployeeService {
	
	Employee addEmployee(Employee employee);
	List<Employee> findAllEmployee();
	List<Employee>  findByDesignation(String designation);
	List<Employee> fuzzySearchByName(String name);
	List<Employee> fuzzySearchBySkill(String skill);
	 List<Employee> autocompleteByName(String prefix);
	 List<Employee> autocompleteBySkill(String prefix);
	

}
