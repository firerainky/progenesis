package com.zky.progenesis.service;

import java.util.List;

import com.zky.progenesis.entity.Employee;

public interface EmployeeService {

    public List<Employee> findAll();
    
    public Employee findById(int id);
    
    public Employee save(Employee employee);
    
    public void deleteById(int id);
}