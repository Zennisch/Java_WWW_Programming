package com.fit.iuh.controllers;

import com.fit.iuh.entities.Address;
import com.fit.iuh.entities.Employee;
import com.fit.iuh.services.AddressService;
import com.fit.iuh.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AddressService addressService;

    @GetMapping("/")
    public String home(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "home";
    }

    @GetMapping("/add")
    public String showAddEmployeeForm(Model model) {
        List<Address> addresses = addressService.findAll();
        model.addAttribute("addresses", addresses);
        model.addAttribute("employee", new Employee());
        return "add";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee employee) {
        int addressId = employee.getAddress().getId();
        Address address = addressService.findById(addressId);
        employee.setAddress(address);
        employeeService.save(employee);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String showEditEmployeeForm(Model model, @RequestParam("id") int id) {
        Employee employee = employeeService.findById(id);
        List<Address> addresses = addressService.findAll();
        model.addAttribute("addresses", addresses);
        model.addAttribute("employee", employee);
        return "edit";
    }

    @PostMapping("/edit")
    public String editEmployee(@ModelAttribute Employee employee) {
        int addressId = employee.getAddress().getId();
        Address address = addressService.findById(addressId);
        employee.setAddress(address);
        employeeService.save(employee);
        return "redirect:/";
    }

}
