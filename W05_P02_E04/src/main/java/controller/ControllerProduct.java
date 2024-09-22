package controller;

import dao.DAO_Product;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/Products")
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
        List<Product> products = daoProduct.getAllProducts();
        System.out.println(products);
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("products", products);
        req.getRequestDispatcher("/products.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
