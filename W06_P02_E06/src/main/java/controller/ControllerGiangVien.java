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
            case "home":
                resp.sendRedirect(req.getContextPath() + "/");
                break;
            case "list":
                List<GiangVien> giangViens = daoGiangVien.getAll();
                HttpSession session = req.getSession();
                req.setAttribute("giangViens", giangViens);
                req.getRequestDispatcher(req.getContextPath() + "/").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
