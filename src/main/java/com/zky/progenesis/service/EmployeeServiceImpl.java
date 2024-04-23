package com.zky.progenesis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zky.progenesis.dao.EmployeeDAO;
import com.zky.progenesis.entity.Employee;

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

    @Override
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    @Override
    public void save(Employee employee) {
        employeeDAO.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeDAO.deleteById(id);
    }
    
}
