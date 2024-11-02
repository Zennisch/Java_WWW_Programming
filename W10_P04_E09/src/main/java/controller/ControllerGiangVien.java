package controller;

import model.GiangVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
