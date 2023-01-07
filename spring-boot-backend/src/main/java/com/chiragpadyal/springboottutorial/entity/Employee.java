package com.chiragpadyal.springboottutorial.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

    // variables
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;
    private String employeeLastName;
    private String employeeFirstName;
    private String employeeEmailAddress;

    // Getter and setter
    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeEmailAddress() {
        return employeeEmailAddress;
    }

    public void setEmployeeEmailAddress(String employeeEmailAddress) {
        this.employeeEmailAddress = employeeEmailAddress;
    }


    // constructor
    public Employee(Long employeeId, String employeeLastName, String employeeFirstName, String employeeEmailAddress) {
        this.employeeId = employeeId;
        this.employeeLastName = employeeLastName;
        this.employeeFirstName = employeeFirstName;
        this.employeeEmailAddress = employeeEmailAddress;
    }

    // default constructor
    public Employee() {

    }

    //toString

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeLastName='" + employeeLastName + '\'' +
                ", employeeFirstName='" + employeeFirstName + '\'' +
                ", employeeEmailAddress='" + employeeEmailAddress + '\'' +
                '}';
    }
}
