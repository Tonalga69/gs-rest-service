package com.example.restservice;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    Employees employees = new Employees(new EmployeeManager());

    @GetMapping(path = "/", produces = "application/json")
    public Employees getEmployees(HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_OK);
        return employees;
    }

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
        int id
                = employees
                .getEmployees()
                .size()
                + 1;
        employee.setEmployee_id(Integer.toString(id));
        employees.addEmployee(employee);
        URI location
                = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(
                        employee.getEmployee_id())
                .toUri();

        return ResponseEntity
                .created(location)
                .build();
    }

}
