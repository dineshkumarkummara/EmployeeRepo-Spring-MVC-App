package com.dk.springmvccrud.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dk.springmvccrud.dao.EmployeeDAO;
import com.dk.springmvccrud.entity.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }


    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

}