package com.dk.springmvccrud.dao;

import com.dk.springmvccrud.entity.Employee;

import java.util.*;

public interface EmployeeDAO {
    List<Employee> findAll();
}
