package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.SinhVien;

@Controller
public class ControllerSinhVien {

    private List<SinhVien> list;

    public ControllerSinhVien() {
        list = new ArrayList<>();
        list.add(new SinhVien(1, "Nguyen", "Nam", 5));
        list.add(new SinhVien(2, "Nguyen", "Anh", 8));
        list.add(new SinhVien(3, "Tran", "Nam", 6));
        list.add(new SinhVien(4, "Tran", "Anh", 9));
        list.add(new SinhVien(5, "Nguyen", "Bao", 7));
        list.add(new SinhVien(6, "Nguyen", "Nhan", 10));
    }

    @RequestMapping("/ViewSinhVien")
    public ModelAndView viewStudent() {
        return new ModelAndView("viewSinhVien", "list", list);
    }

}
