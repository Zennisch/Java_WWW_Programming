package controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import model.DeTai;
import model.GiangVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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

    @GetMapping("/check")
    public String checkDeTai(@RequestParam("maDeTai") Integer maDeTai, Model model) {
        DeTai deTai = service_deTai.getDeTaiById(maDeTai);
        model.addAttribute("deTai", deTai);
        return "checkDeTai";
    }

    @GetMapping("/form-create")
    public String formCreateDeTai(Model model) {
        List<GiangVien> listGiangVien = service_deTai.getAllGiangVien();

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int startYear = 2000;
        List<Integer> listNam = IntStream.range(startYear, currentYear)
                .map(i -> currentYear - i + startYear)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        if (!model.containsAttribute("deTai"))
            model.addAttribute("deTai", new DeTai());

        model.addAttribute("listGiangVien", listGiangVien);
        model.addAttribute("listNam", listNam);

        return "formCreateDeTai";
    }

    private static final String UPLOAD_DIR = "WEB-INF/resources/image_DeTai/";
    private static final String UPLOAD_URL = "/resources/image_DeTai/";

    @PostMapping("/create")
    public String createDeTai(
            @Valid @ModelAttribute("deTai") DeTai deTai,
            BindingResult bindingResult,
            @RequestParam("hinh") MultipartFile hinh,
            HttpSession session,
            RedirectAttributes redirectAttributes
    ) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.deTai", bindingResult);
            redirectAttributes.addFlashAttribute("deTai", deTai);
            return "redirect:/DeTai/form-create";
        } else {
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
            try {
                hinh.transferTo(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            String fileUrl = UPLOAD_URL + fileName;
            deTai.setUrlHinh(fileUrl);
            boolean statusUpdate = service_deTai.updateDeTai(deTai);
            if (!statusUpdate)
                System.err.println("Error: updateDeTai failed for deTai: " + deTai);

            return "redirect:/DeTai/";
        }
    }

    @GetMapping("/form-update")
    public String formUpdateDeTai(@RequestParam("maDeTai") Integer maDeTai, Model model) {
        List<GiangVien> listGiangVien = service_deTai.getAllGiangVien();

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int startYear = 2000;
        List<Integer> listNam = IntStream.range(startYear, currentYear)
                .map(i -> currentYear - i + startYear)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        if (!model.containsAttribute("deTai")) {
            DeTai deTai = service_deTai.getDeTaiById(maDeTai);
            model.addAttribute("deTai", deTai);
        }
        model.addAttribute("listGiangVien", listGiangVien);
        model.addAttribute("listNam", listNam);

        return "formUpdateDeTai";
    }

    @PostMapping("/update")
    public String updateDeTai(
            @Valid @ModelAttribute("deTai") DeTai deTai,
            BindingResult bindingResult,
            @RequestParam("hinh") MultipartFile hinh,
            HttpSession session,
            RedirectAttributes redirectAttributes
    ) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.deTai", bindingResult);
            redirectAttributes.addFlashAttribute("deTai", deTai);
            return "redirect:/DeTai/form-update?maDeTai=" + deTai.getMaDeTai();
        } else {
            DeTai oldDeTai = service_deTai.getDeTaiById(deTai.getMaDeTai());
            deTai.setUrlHinh(oldDeTai.getUrlHinh());

            if (hinh == null || hinh.isEmpty()) {
                boolean statusUpdate = service_deTai.updateDeTai(deTai);
                if (!statusUpdate)
                    System.err.println("Error: updateDeTai failed for deTai: " + deTai);

            } else {
                ServletContext context = session.getServletContext();
                String realPath = context.getRealPath(UPLOAD_DIR);
                String fileName = deTai.getMaDeTai() + "_" + hinh.getOriginalFilename();

                String filePath = realPath + fileName;
                File file = new File(filePath);
                try {
                    hinh.transferTo(file);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                String fileUrl = UPLOAD_URL + fileName;
                deTai.setUrlHinh(fileUrl);
                boolean statusUpdate = service_deTai.updateDeTai(deTai);
                if (!statusUpdate)
                    System.err.println("Error: updateDeTai failed for deTai: " + deTai);

            }
            return "redirect:/DeTai/";
        }
    }

    @GetMapping("/delete")
    public String deleteDeTai(@RequestParam("maDeTai") Integer maDeTai) {
        boolean statusDelete = service_deTai.deleteDeTai(maDeTai);
        if (!statusDelete)
            System.err.println("Error: deleteDeTai failed for maDeTai: " + maDeTai);

        return "redirect:/DeTai/";
    }
}
