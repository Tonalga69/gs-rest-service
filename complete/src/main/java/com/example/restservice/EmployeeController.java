package com.example.restservice;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
Employees employees= new Employees(new EmployeeManager());

    @GetMapping(path = "/", produces = "application/json")
    public Employees getEmployees() {
        return employees;
    }

    @PostMapping(path = "/", consumes = "application/json")
    public void addEmployee(@RequestBody Employee employee, HttpServletResponse response) {
        employees.addEmployee(employee);
        response.setStatus(HttpServletResponse.SC_CREATED);
    }

}
