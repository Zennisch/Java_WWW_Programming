package controller;

import dao.DAO_DienThoai;
import dao_interface.I_DAO_DienThoai;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import utility.HibernateUtility;

public class ControllerDienThoai extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private HibernateUtility hibernateUtility;
    private EntityManager entityManager;
    private I_DAO_DienThoai iDaoDienThoai;

    public ControllerDienThoai() {
        super();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        hibernateUtility = new HibernateUtility();
        entityManager = hibernateUtility.getEntityManager();
        iDaoDienThoai = new DAO_DienThoai(entityManager);
    }

    @Override
    public void destroy() {
        hibernateUtility.close();
        super.destroy();
    }
}
