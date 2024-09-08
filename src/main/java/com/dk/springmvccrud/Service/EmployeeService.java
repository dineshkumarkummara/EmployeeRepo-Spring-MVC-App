package com.dk.springmvccrud.Service;

import com.dk.springmvccrud.entity.Employee;

import java.util.*;

public interface EmployeeService {

	List<Employee> findAll();
	
	Employee findById(int theId);
	
	void save(Employee theEmployee);
	
	void deleteById(int theId);
	
}