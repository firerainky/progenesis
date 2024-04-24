package com.zky.progenesis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zky.progenesis.dao.EmployeeRepository;
import com.zky.progenesis.entity.Employee;

@Service
public class EmployeeServiceRepoImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceRepoImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
    
}
