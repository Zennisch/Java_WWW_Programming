package controller;

import dao.DAO_DanhMuc;
import dao.DAO_TinTuc;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DanhMuc;
import model.TinTuc;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/TinTuc", "/TinTuc*"})
public class ControllerTinTuc extends HttpServlet {

    @Resource(name = "jdbc/QLTinTuc")
    private DataSource dataSource;

    private DAO_TinTuc daoTinTuc;
    private DAO_DanhMuc daoDanhMuc;

    public ControllerTinTuc() {
        super();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        daoTinTuc = new DAO_TinTuc(dataSource);
        daoDanhMuc = new DAO_DanhMuc(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action")  != null ? req.getParameter("action") : "home";

        switch (action) {
            case "list":
                doGetList(req, resp);
                break;
            case "detail":
                doGetDetail(req, resp);
                break;
            case "category":
                doGetCategory(req, resp);
                break;
            default:
                doGetHome(req, resp);
                break;
        }
    }

    private void doGetHome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(req.getContextPath() + "/").forward(req, resp);
    }

    private void doGetList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TinTuc> listTinTuc = daoTinTuc.getAllTinTuc();
        req.setAttribute("listTinTuc", listTinTuc);
        req.getRequestDispatcher(req.getContextPath() + "/").forward(req, resp);
    }

    private void doGetDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maTinTuc = req.getParameter("id");
        TinTuc tinTuc = daoTinTuc.getTinTucById(maTinTuc);
        req.setAttribute("tinTuc", tinTuc);
        req.getRequestDispatcher(req.getContextPath() + "/").forward(req, resp);
    }

    private void doGetCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<DanhMuc> listDanhMuc = daoDanhMuc.getAllDanhMuc();
        req.setAttribute("listDanhMuc", listDanhMuc);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
