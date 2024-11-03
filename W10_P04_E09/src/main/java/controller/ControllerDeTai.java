package controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import model.DeTai;
import model.GiangVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import service_interface.I_Service_DeTai;

import java.io.File;
import java.io.IOException;
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

    private static final String UPLOAD_DIR = "WEB-INF/resources/image_DeTai/";
    private static final String UPLOAD_URL = "/resources/image_DeTai/";

    @PostMapping("/create")
    public String createDeTai(
            HttpSession session,
            @ModelAttribute("deTai") DeTai deTai,
            @RequestParam("hinh") MultipartFile hinh
    ) throws IOException {
        boolean statusCreate = service_deTai.createDeTai(deTai);
        if (!statusCreate)
            return "redirect:/DeTai/form-create";

        if (hinh == null || hinh.isEmpty())
            return "redirect:/DeTai/";

        ServletContext context = session.getServletContext();
        String realPath = context.getRealPath(UPLOAD_DIR);
        String fileName = deTai.getMaDeTai() + "_" + hinh.getOriginalFilename();

        String filePath = realPath + fileName;
        File file = new File(filePath);
        hinh.transferTo(file);

        String fileUrl = UPLOAD_URL + fileName;
        deTai.setUrlHinh(fileUrl);
        boolean statusUpdate = service_deTai.updateDeTai(deTai);
        if (!statusUpdate)
            System.err.println("Error: updateDeTai failed for deTai: " + deTai);

        return "redirect:/DeTai/";
    }

    @GetMapping("/delete")
    public String deleteDeTai(@RequestParam("maDeTai") Integer maDeTai) {
        boolean statusDelete = service_deTai.deleteDeTai(maDeTai);
        if (!statusDelete)
            System.err.println("Error: deleteDeTai failed for maDeTai: " + maDeTai);

        return "redirect:/DeTai/";
    }
}
