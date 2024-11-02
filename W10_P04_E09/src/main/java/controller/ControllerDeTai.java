package controller;

import dao_interface.I_DAO_DeTai;
import model.DeTai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service_interface.I_Service_DeTai;

import java.util.List;

@Controller
@RequestMapping("/DeTai")
public class ControllerDeTai {

    @Autowired
    private I_Service_DeTai service_deTai;

    @GetMapping("/")
    public String listDeTai(Model model) {
        List<DeTai> listDeTai = service_deTai.getAllDeTai();
        model.addAttribute("listDeTai", listDeTai);
        return "deTai";
    }

}
