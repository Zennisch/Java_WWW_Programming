package controller;

import dao.DAO_Book;
import dao.DAO_OrderDetail;
import dao.DAO_Orders;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Book;
import model.ItemCart;
import model.OrderDetail;
import model.Orders;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Checkout")
public class ControllerCheckout extends HttpServlet {

    @Resource(name = "jdbc/Book")
    private DataSource dataSource;

    private DAO_Orders daoOrder;
    private DAO_OrderDetail daoOrderDetail;

    public ControllerCheckout() {
        super();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        daoOrder = new DAO_Orders(dataSource);
        daoOrderDetail = new DAO_OrderDetail(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ItemCart> cart = (List<ItemCart>) req.getAttribute("cart");

        daoOrder.addOrder();
        Orders order = daoOrder.getLatestOrder();

        List<OrderDetail> orderDetails = new ArrayList<>();
        for (ItemCart item : cart) {

            Book book = item.getBook();
            int quantity = item.getQuantity();

            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder(order);
            orderDetail.setBook(book);
            orderDetail.setQuantity(quantity);

            orderDetails.add(orderDetail);
        }

        for (OrderDetail orderDetail : orderDetails) {
            daoOrderDetail.addOrderDetail(orderDetail);
        }

        req.getRequestDispatcher("/checkout.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
