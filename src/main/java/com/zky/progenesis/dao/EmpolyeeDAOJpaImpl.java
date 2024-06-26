package com.zky.progenesis.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zky.progenesis.entity.Employee;

import jakarta.persistence.EntityManager;

@Repository
public class EmpolyeeDAOJpaImpl implements EmployeeDAO {
    
    private EntityManager entityManager;

    public EmpolyeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        // Get all employees
        List<Employee> employees = entityManager.createQuery("from Employee", Employee.class).getResultList();
        return employees;
    }

    @Override
    public Employee findById(int id) {
        // Get the employee with the given id
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {
        // Save or update the employee
        // If id==0 then save/insert else update
        Employee dbEmployee = entityManager.merge(employee);
        return dbEmployee;
    }

    @Override
    public void deleteById(int id) {
        // Delete the employee with the given id
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }
}
