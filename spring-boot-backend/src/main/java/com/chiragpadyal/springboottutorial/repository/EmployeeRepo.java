package com.chiragpadyal.springboottutorial.repository;

import com.chiragpadyal.springboottutorial.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    public Employee findByEmployeeFirstName(String departmentName);
}
