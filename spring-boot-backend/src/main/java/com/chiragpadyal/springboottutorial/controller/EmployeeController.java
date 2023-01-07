package com.chiragpadyal.springboottutorial.controller;

import com.chiragpadyal.springboottutorial.entity.Employee;
import com.chiragpadyal.springboottutorial.error.EmployeeNotFoundException;
import com.chiragpadyal.springboottutorial.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.http.MediaType;

import java.util.List;



@RestController
@CrossOrigin(origins = "*")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeServices;

    @PreAuthorize("hasAuthority('create:employees')")
    @PostMapping("/employees")
    public Employee saveEmployee (@RequestBody Employee employee){
        return employeeServices.saveEmployee(employee);
    }

    @PreAuthorize("hasAuthority('read:employees')")
    @GetMapping("/employees")
    public List<Employee> fetchEmployeeList (){
        return employeeServices.fetchEmployeeList();
    }
    @GetMapping("/employees/{id}")
    public Employee fetchEmployeeByID (@PathVariable("id") Long employeeId) throws EmployeeNotFoundException {
        return employeeServices.fetchEmployeeByID(employeeId);
    }
    @PreAuthorize("hasAuthority('delete:employees')")
    @DeleteMapping("/employees/{id}")
    public String deleteEmployeeById (@PathVariable("id") Long employeeId ){
        employeeServices.deleteEmployeeById(employeeId);
        return "Deleted entry!";
    }

    @PreAuthorize("hasAuthority('update:employees')")
    @PutMapping("/employees/{id}")
    public Employee updateEmployeeByID (@PathVariable("id") Long employeeId, @RequestBody Employee employee){
        return employeeServices.updateEmployeeByID(employeeId, employee);
    }

    @GetMapping("/employees/name/{name}")
    public Employee fetchEmployeeByName (@PathVariable("name") String employeeFirstName){
        return employeeServices.fetchEmployeeByName(employeeFirstName);
    }


}
