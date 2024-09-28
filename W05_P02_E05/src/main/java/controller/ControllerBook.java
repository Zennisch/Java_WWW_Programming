package controller;

import dao.DAO_Book;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
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

@WebServlet("/Books")
public class ControllerBook extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/Book")
    private DataSource dataSource;

    private DAO_Book daoBook;

    public ControllerBook() {
        super();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
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
        daoBook = new DAO_Book(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("books", daoBook.getAllBooks());
        req.getRequestDispatcher("/books.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
