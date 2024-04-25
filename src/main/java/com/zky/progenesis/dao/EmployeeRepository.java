package com.zky.progenesis.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.zky.progenesis.entity.Employee;

// With Spring Data REST, we don't need to write any implementation code or boilerplate code
// We already get REST API /employees, GET / POST / PUT / DELETE...
// In such generated API, id is only added in url, not in request body
// And if can not find an employee, it will return success status 204 No Content
// The default endpoint path is followed simple pluralized form of the entity class name: Employee -> /employees
// Its properties in application.properties are started with spring.data.rest.*
// Sort by first name, descending: http://localhost:8080/api/employees?sort=firstName,desc
// Sort by last name, then first name, ascending: http://localhost:8080/api/employees?sort=lastName,firstName

@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    
    // that's it ... no need to write any code LOL!
}