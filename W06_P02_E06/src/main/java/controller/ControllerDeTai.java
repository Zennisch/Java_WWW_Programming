package controller;

import dao.DAO_DeTai;
import dao.DAO_GiangVien;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DeTai;
import model.GiangVien;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/DeTai", "/DeTai*"})
public class ControllerDeTai extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/QLGiangVien")
    private DataSource dataSource;

    private DAO_DeTai daoDeTai;
    private DAO_GiangVien daoGiangVien;

    public ControllerDeTai() {
        super();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        daoDeTai = new DAO_DeTai(dataSource);
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
        List<DeTai> deTais = daoDeTai.getAll();
        req.setAttribute("deTais", deTais);
        req.getRequestDispatcher(req.getContextPath() + "/").forward(req, resp);
    }

    private void doPostAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maDT = req.getParameter("maDeTai");
        String tenDT = req.getParameter("tenDeTai");
        String namDangKyString = req.getParameter("namDangKy");
        String moTaDeTai = req.getParameter("moTa");
        String maGV = req.getParameter("giangVien");

        int namDangKy = Integer.parseInt(namDangKyString);
        GiangVien giangVien = daoGiangVien.getByID(maGV);

        DeTai deTai = new DeTai(maDT, tenDT, namDangKy, moTaDeTai, giangVien);

        boolean isAdded = daoDeTai.add(deTai);
        if (isAdded) {
            req.getSession().setAttribute("message", "Thêm đề tài thành công");
            resp.sendRedirect(req.getContextPath() + "/DeTai?action=list");
        } else {
            req.getSession().setAttribute("message", "Thêm đề tài thất bại");
            resp.sendRedirect(req.getContextPath() + "/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPostAdd(req, resp);
    }
}
