package com.elasticsearch.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elasticsearch.enity.Employee;
import com.elasticsearch.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
	
	private final  EmployeeService empService;

	@PostMapping
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		 Employee res = empService.addEmployee(employee);
		 return new ResponseEntity<>(res,HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Employee>> findAllEmployee() {
		List<Employee> res = empService.findAllEmployee();
		 return new ResponseEntity<>(res,HttpStatus.OK);
	}

	@GetMapping("/designation/{designation}")
	public List<Employee> findByDesignation(@PathVariable("designation") String designation) {
		return empService.findByDesignation(designation);
	}

	@GetMapping("/name")
	public List<Employee> fuzzySearchByName(@RequestParam(name = "name", required = true) String name) {
		return empService.fuzzySearchByName(name);
	}

	@GetMapping("/skill/{skill}")
	public List<Employee> fuzzySearchBySkill(@PathVariable() String skill) {
		return empService.fuzzySearchBySkill(skill);
	}

	@GetMapping("/auto/{prefix}")
	public List<Employee> autocompleteByName(@PathVariable() String prefix) {
		return empService.autocompleteByName(prefix);
	}

	@GetMapping("/auto/skill/{prefix}")
	public List<Employee> autocompleteBySkill(@PathVariable() String prefix) {
		return empService.autocompleteBySkill(prefix);
	}
	
	

}
