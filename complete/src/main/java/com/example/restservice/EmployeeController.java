package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {


    @GetMapping("/")
    public Employees getEmployees() {
        return new Employees(new EmployeeManager());
    }
}
