package com.chiragpadyal.springboottutorial.services;

import com.chiragpadyal.springboottutorial.entity.Employee;
import com.chiragpadyal.springboottutorial.error.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeService {
    public Employee saveEmployee(Employee employee);

    public List<Employee> fetchEmployeeList();

    public Employee fetchEmployeeByID(Long employeeId) throws EmployeeNotFoundException;

    public void deleteEmployeeById(Long employeeId);

    public Employee updateEmployeeByID(Long employeeId, Employee employee);

    public Employee fetchEmployeeByName(String employeeFirstName);
}
