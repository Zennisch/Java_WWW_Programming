package controller;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service_interface.I_Service_Customer;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class ControllerCustomer {

    @Autowired
    private I_Service_Customer service_customer;

    @GetMapping("/")
    public String home(Model model) {
        List<Customer> customers = service_customer.getAllCustomers();
        model.addAttribute("customers", customers);
        return "customers";
    }

    @GetMapping("/add-form")
    public String addForm(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "add-form";
    }

    @PostMapping("/create")
    public String createCustomer(@ModelAttribute("customer") Customer customer) {
        service_customer.createCustomer(customer);
        return "redirect:/";
    }

}
