package com.zky.progenesis.dao;

import java.util.List;

import com.zky.progenesis.entity.Employee;

import jakarta.persistence.EntityManager;

public class EmpolyeeDAOJpaImpl implements EmployeeDAO {
    
    private EntityManager entityManager;

    public EmpolyeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        // Get all employees
        return entityManager.createQuery("from Employee", Employee.class).getResultList();
    }

    @Override
    public Employee findById(int id) {
        // Get the employee with the given id
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void save(Employee employee) {
        // Save or update the employee
        Employee dbEmployee = entityManager.merge(employee);
        employee.setId(dbEmployee.getId());
    }

    @Override
    public void deleteById(int id) {
        // Delete the employee with the given id
        Employee employee = entityManager.find(Employee.class, id);
        if (employee != null) {
            entityManager.remove(employee);
        }
    }
}
