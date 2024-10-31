package controller;

import org.springframework.stereotype.Controller;
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
    public String requestFormStudent() {
        return "form-student";
    }

    @RequestMapping("/form-customer")
    public String requestFormCustomer() {
        return "form-customer";
    }


}
