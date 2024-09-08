package com.dk.springmvccrud.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dk.springmvccrud.entity.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee,Integer> {
    
}
