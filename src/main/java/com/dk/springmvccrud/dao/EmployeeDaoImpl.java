package com.dk.springmvccrud.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dk.springmvccrud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO{
    private EntityManager entityManager;

    public EmployeeDaoImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> employeeQuery =entityManager.createQuery("From Employee ",Employee.class);
        List<Employee> employees =employeeQuery.getResultList();
        return employees;
    }
}
