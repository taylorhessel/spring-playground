package com.example.demo.employee;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeesController {

    private final EmployeeRepository repo;

    public EmployeesController(EmployeeRepository employeeRepository) {
        this.repo = employeeRepository;
    }

    @GetMapping("")
    @JsonView(Views.UserView.class)
    public Iterable<Employee> list() {
        return repo.findAll();
    }

}
