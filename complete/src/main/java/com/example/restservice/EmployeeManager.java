package com.example.restservice;

import java.util.ArrayList;

public class EmployeeManager {
    private final ArrayList<Employee> employees = new ArrayList<Employee>();

    public EmployeeManager() {
        employees.add(new Employee("1", "John", "Smith", "example@example.com", "Fullstack developer"));
        employees.add(new Employee("2", "Samuel", "Ramos", "example2@example.com, ", "Frontend developer"));
        employees.add(new Employee("3", "Maria", "Gonzalez", "example3@example.com", "Backend developer"));
        employees.add(new Employee("4", "Luis", "Perez", "example4@exampple.com", "CEO"));
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }


}
