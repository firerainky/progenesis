package com.zky.progenesis.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zky.progenesis.entity.Employee;
import com.zky.progenesis.service.EmployeeService;



@RestController
@RequestMapping("/api")
public class EmployeeController {
    
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        List<Employee> employees =  employeeService.findAll();
        return employees;
    }
}
