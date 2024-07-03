package com.example.restservice;

import java.util.ArrayList;

public class Employees {
    private final ArrayList<Employee> employees;

    public Employees(EmployeeManager employeeManager) {
        employees = employeeManager.getEmployees();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public Employee getEmployee(String employee_id) {
        for (Employee employee : employees) {
            if (employee.getEmployee_id().equals(employee_id)) {
                return employee;
            }
        }
        return null;
    }
}
