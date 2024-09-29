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
            case "add":
                doGetAdd(req, resp);
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

    private void doGetAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
