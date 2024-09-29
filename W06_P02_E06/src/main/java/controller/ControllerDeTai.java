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

@WebServlet(urlPatterns = {"/DeTai", "/DeTai*"})
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
        List<DeTai> deTais = daoDeTai.getAll();
        req.setAttribute("deTais", deTais);
        req.getRequestDispatcher(req.getContextPath() + "/").forward(req, resp);
    }

    private void doGetAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
