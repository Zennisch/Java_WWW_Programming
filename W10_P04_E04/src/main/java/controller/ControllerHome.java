package controller;

import jakarta.validation.Valid;
import model.Customer;
import model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        // Check if the model contains the attribute "customer"
        // If yes, keep the attribute "customer" in the model which is also has the error messages
        // If not, add the attribute "customer" to the model
        if (!model.containsAttribute("customer")) {
            model.addAttribute("customer", new Customer());
        }
        return "form-customer";
    }

    @RequestMapping("/confirm-customer")
    public String requestProcessCustomer(
            @Valid @ModelAttribute("customer") Customer customer,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
        // Here, what I want to do here is if the form has errors,
        // I want to redirect to the form-customer page instead of
        // keeping the confirm-customer page which is not logical
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.customer", bindingResult);
            redirectAttributes.addFlashAttribute("customer", customer);

            return "redirect:/form-customer";
        } else {
            return "confirm-customer";
        }
    }

}
