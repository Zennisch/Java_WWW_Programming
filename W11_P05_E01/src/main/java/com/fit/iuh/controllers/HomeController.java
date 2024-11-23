package com.fit.iuh.controllers;

import com.fit.iuh.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

}
