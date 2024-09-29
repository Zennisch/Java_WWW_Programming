package controller;

import dao.DAO_GiangVien;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.GiangVien;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/GiangVien", "/GiangVien*"})
public class ControllerGiangVien extends HttpServlet {

    @Resource(name = "jdbc/QLGiangVien")
    private DataSource dataSource;

    private DAO_GiangVien daoGiangVien;

    public ControllerGiangVien() {
        super();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        daoGiangVien = new DAO_GiangVien(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action") != null ? req.getParameter("action") : "home";

        switch (action) {
            case "list":
                doGetList(req, resp);
                break;
            default:
                doGetHome(req, resp);
                break;
        }
    }

    private void doGetHome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + "/");
    }

    private void doGetList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<GiangVien> giangViens = daoGiangVien.getAll();
        req.setAttribute("giangViens", giangViens);
        req.getRequestDispatcher(req.getContextPath() + "/").forward(req, resp);
    }

    private void doPostAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maGV = req.getParameter("maGiangVien");
        String tenGV = req.getParameter("tenGiangVien");
        String linhVucNghienCuu = req.getParameter("linhVucNghienCuu");
        String soDienThoai = req.getParameter("soDienThoai");

        GiangVien giangVien = new GiangVien(maGV, tenGV, linhVucNghienCuu, soDienThoai);
        boolean isAdded = daoGiangVien.add(giangVien);
        if (isAdded) {
            req.setAttribute("message", "Thêm giảng viên thành công");
            resp.sendRedirect(req.getContextPath() + "/GiangVien?action=list");
        } else {
            req.setAttribute("message", "Thêm giảng viên thất bại");
            req.getRequestDispatcher(req.getContextPath() + "/").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPostAdd(req, resp);
    }
}
