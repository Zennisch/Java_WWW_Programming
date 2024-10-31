package controller;

import model.Customer;
import model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerHome {

    @RequestMapping("/")
    public String requestHome() {
        return "home";
    }

    @RequestMapping("/hello")
    public String requestHello() {
        return "hello";
    }

    @RequestMapping("/form-student")
    public String requestFormStudent(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "form-student";
    }

    @RequestMapping("/confirm-student")
    public String requestProcessStudent(@ModelAttribute("student") Student student) {
        return "confirm-student";
    }

    @RequestMapping("/form-customer")
    public String requestFormCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "form-customer";
    }

    @RequestMapping("/confirm-customer")
    public String requestProcessCustomer(@ModelAttribute("customer") Customer customer) {
        return "confirm-customer";
    }

}
