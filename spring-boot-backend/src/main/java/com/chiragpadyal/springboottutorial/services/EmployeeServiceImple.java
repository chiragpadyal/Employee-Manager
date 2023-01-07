package com.chiragpadyal.springboottutorial.services;

import com.chiragpadyal.springboottutorial.entity.Employee;
import com.chiragpadyal.springboottutorial.error.EmployeeNotFoundException;
import com.chiragpadyal.springboottutorial.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImple implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public List<Employee> fetchEmployeeList() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee fetchEmployeeByID(Long employeeId) throws EmployeeNotFoundException {
        Optional<Employee> dp = employeeRepo.findById(employeeId);
        if(!dp.isPresent()){
            throw new EmployeeNotFoundException("Department Not Available");
        }
        return dp.get();
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {
        employeeRepo.deleteById(employeeId);
    }

    @Override
    public Employee updateEmployeeByID(Long employeeId, Employee employee) {
        Employee dp = employeeRepo.findById(employeeId).get();
        if(Objects.nonNull(employee.getEmployeeFirstName()) && !"".equalsIgnoreCase(employee.getEmployeeFirstName())){
            dp.setEmployeeFirstName(employee.getEmployeeFirstName());
        }

        if(Objects.nonNull(employee.getEmployeeLastName()) && !"".equalsIgnoreCase(employee.getEmployeeLastName())){
            dp.setEmployeeLastName(employee.getEmployeeLastName());
        }

        if(Objects.nonNull(employee.getEmployeeEmailAddress()) && !"".equalsIgnoreCase(employee.getEmployeeEmailAddress())){
            dp.setEmployeeEmailAddress(employee.getEmployeeEmailAddress());
        }

        return employeeRepo.save(dp);
    }

    @Override
    public Employee fetchEmployeeByName(String employeeFirstName) {
        return employeeRepo.findByEmployeeFirstName(employeeFirstName);
    }
}
