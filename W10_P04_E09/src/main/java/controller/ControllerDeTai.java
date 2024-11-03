package controller;

import model.DeTai;
import model.GiangVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import service_interface.I_Service_DeTai;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.IntStream;

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

    @GetMapping("/form-create")
    public String formCreateDeTai(Model model) {
        DeTai deTai = new DeTai();
        List<GiangVien> listGiangVien = service_deTai.getAllGiangVien();

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int startYear = 2000;
        List<Integer> listNam = IntStream.range(startYear, currentYear)
                .map(i -> currentYear - i + startYear)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);


        model.addAttribute("deTai", deTai);
        model.addAttribute("listGiangVien", listGiangVien);
        model.addAttribute("listNam", listNam);

        return "formCreateDeTai";
    }

    @PostMapping("/create")
    public String createDeTai(
            @ModelAttribute("deTai") DeTai deTai,
            @RequestParam("hinh") MultipartFile hinh
    ) {
        System.out.println(deTai);
        System.out.println(hinh.getOriginalFilename());
        return "redirect:/DeTai/";
    }

}
