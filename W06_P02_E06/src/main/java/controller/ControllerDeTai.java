package controller;

import dao.DAO_DeTai;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DeTai;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet("/DeTai")
public class ControllerDeTai extends HttpServlet {

    @Resource(name = "jdbc/QLGiangVien")
    private DataSource dataSource;

    private DAO_DeTai daoDeTai;

    public ControllerDeTai() {
        super();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        daoDeTai = new DAO_DeTai(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<DeTai> deTais = daoDeTai.getAll();
        resp.setContentType("text/html");
        resp.getWriter().println(deTais);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
