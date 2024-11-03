package controller;

import jakarta.validation.Valid;
import model.GiangVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service_interface.I_Service_GiangVien;

import java.util.List;

@Controller
@RequestMapping("/GiangVien")
public class ControllerGiangVien {

    @Autowired
    private I_Service_GiangVien service_giangVien;

    @GetMapping("/")
    public String listGiangVien(Model model) {
        List<GiangVien> listGiangVien = service_giangVien.getAllGiangVien();
        model.addAttribute("listGiangVien", listGiangVien);
        return "giangVien";
    }

    @GetMapping("/form-create")
    public String formCreateGiangVien(Model model) {
        if (!model.containsAttribute("giangVien"))
            model.addAttribute("giangVien", new GiangVien());
        return "formCreateGiangVien";
    }

    @PostMapping("/create")
    public String createGiangVien(
            @Valid @ModelAttribute("giangVien") GiangVien giangVien,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.giangVien", bindingResult);
            redirectAttributes.addFlashAttribute("giangVien", giangVien);
            return "redirect:/GiangVien/form-create";
        }

        boolean status = service_giangVien.createGiangVien(giangVien);
        if (!status)
            System.err.println("Error: createGiangVien failed for giangVien: " + giangVien);
        return "redirect:/GiangVien/";
    }

}
