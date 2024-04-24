package com.zky.progenesis.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zky.progenesis.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    
    // that's it ... no need to write any code LOL!
}
