package com.fit.iuh.controller;

import com.fit.iuh.service.GiangVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private GiangVienService giangVienService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Hello, World!");
        model.addAttribute("giangViens", giangVienService.getAll());
        return "index";
    }

}
