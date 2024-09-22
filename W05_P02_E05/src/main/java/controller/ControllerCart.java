package controller;

import dao.DAO_Book;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.ItemCart;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/cart", "/cart*"})
public class ControllerCart extends HttpServlet {

    @Resource(name = "jdbc/Book")
    private DataSource dataSource;

    private DAO_Book daoBook;

    public ControllerCart() {
        super();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        daoBook = new DAO_Book(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action") != null ? req.getParameter("action") : "";

        switch (action) {
            case "buy":
                doGetBuy(req, resp);
                break;
            case "remove":
                doGetRemove(req, resp);
                break;
            case "checkout":
                doGetCheckout(req, resp);
                break;
            default:
                doGetDisplayCart(req, resp);
                break;
        }
    }

    private void doGetDisplayCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/cart.jsp").forward(req, resp);
    }

    private void doGetBuy(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<ItemCart> cart;

        if (session.getAttribute("cart") == null) {
            cart = new ArrayList<>();
        } else {
            cart = (List<ItemCart>) session.getAttribute("cart");
        }
        int index = isProductExist(Integer.parseInt(req.getParameter("id")), cart);
        if (index == -1) {
            cart.add(new ItemCart(daoBook.getBook(Integer.parseInt(req.getParameter("id"))), 1));
        } else {
            int quantity = cart.get(index).getQuantity() + 1;
            cart.get(index).setQuantity(quantity);
        }
        session.setAttribute("cart", cart);
        resp.sendRedirect("cart");
    }

    private int isProductExist(int id, List<ItemCart> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getBook().getId() == id) {
                return i;
            }
        }
        return -1;
    }

    private void doGetRemove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<ItemCart> cart = (List<ItemCart>) session.getAttribute("cart");
        int index = isProductExist(Integer.parseInt(req.getParameter("id")), cart);
        cart.remove(index);
        session.setAttribute("cart", cart);
        resp.sendRedirect("cart");
    }

    private void doGetCheckout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<ItemCart> cart = (List<ItemCart>) session.getAttribute("cart");
        req.setAttribute("cart", cart);
        req.getRequestDispatcher("/Checkout").forward(req, resp);
    }
}
