package controller;

import dao.DAO_GiangVien;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.GiangVien;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet("/GiangVien")
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
        List<GiangVien> giangViens = daoGiangVien.getAll();
        resp.setContentType("text/html");
        resp.getWriter().println(giangViens);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
