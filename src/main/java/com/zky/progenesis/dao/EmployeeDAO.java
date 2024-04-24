package com.zky.progenesis.dao;
import java.util.List;

import com.zky.progenesis.entity.Employee; // Import the Employee class

public interface EmployeeDAO {
    public List<Employee> findAll();
    
    public Employee findById(int id);
    
    public Employee save(Employee employee);
    
    public void deleteById(int id);
}
