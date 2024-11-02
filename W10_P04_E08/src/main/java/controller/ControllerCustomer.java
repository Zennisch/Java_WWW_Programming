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

    @GetMapping("/create-form")
    public String addForm(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "create-form";
    }

    @PostMapping("/create")
    public String createCustomer(@ModelAttribute("customer") Customer customer) {
        boolean status = service_customer.createCustomer(customer);
        if (status) {
            return "redirect:/customer/";
        } else {
            return "redirect:/customer/add-form";
        }
    }

    @GetMapping("/update-form")
    public String updateForm(@ModelAttribute("id") int id, Model model) {
        Customer customer = service_customer.getCustomerById(id);
        model.addAttribute("customer", customer);
        return "update-form";
    }

    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute("customer") Customer customer) {
        boolean status = service_customer.updateCustomer(customer);
        if (status) {
            return "redirect:/customer/";
        } else {
            return "redirect:/customer/update-form";
        }
    }

    @GetMapping("/delete")
    public String deleteCustomer(@ModelAttribute("id") int id) {
        boolean status = service_customer.deleteCustomer(id);
        if (status) {
            return "redirect:/customer/";
        } else {
            return "redirect:/customer/";
        }
    }

}
