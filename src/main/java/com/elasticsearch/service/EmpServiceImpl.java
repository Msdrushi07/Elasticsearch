package com.elasticsearch.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.elasticsearch.enity.Employee;
import com.elasticsearch.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpServiceImpl implements EmployeeService {
	
	private final EmployeeRepository empRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		return empRepository.save(employee);
	}

	@Override
	public List<Employee> findAllEmployee() {
		Iterable<Employee> employees =  empRepository.findAll();
		return StreamSupport.stream(employees.spliterator(), false).collect(Collectors.toList());
	}

	@Override
	public List<Employee> findByDesignation(String designation) {
		return empRepository.findByDesignation(designation);
	}

	@Override
	public List<Employee> fuzzySearchByName(String name) {
		return empRepository.fuzzySearchByName(name);
	}

	@Override
	public List<Employee> fuzzySearchBySkill(String skill) {
		return empRepository.fuzzySearchBySkill(skill);
	}

	@Override
	public List<Employee> autocompleteByName(String prefix) {
		return empRepository.autocompleteByName(prefix);
	}

	@Override
	public List<Employee> autocompleteBySkill(String prefix) {
		return empRepository.autocompleteBySkill(prefix);
	}

}
