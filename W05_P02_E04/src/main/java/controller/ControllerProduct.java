package controller;

import dao.DAO_Product;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/Product")
public class ControllerProduct extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/Shopping")
    private DataSource dataSource;

    private DAO_Product daoProduct;

    public ControllerProduct() {
        super();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            Connection connection = dataSource.getConnection();
            String sql = "SELECT 'Connect to database successfully' AS MESSAGE";
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            if (resultSet.next()) {
                System.out.println(resultSet.getString("MESSAGE"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        daoProduct = new DAO_Product(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("Hello from ControllerProduct");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
