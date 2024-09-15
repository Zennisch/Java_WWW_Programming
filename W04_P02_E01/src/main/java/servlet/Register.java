package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Person;
import model.Qualification;

import java.io.IOException;

@WebServlet("/Register")
public class Register extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        String day = req.getParameter("day");
        String month = req.getParameter("month");
        String year = req.getParameter("year");
        String dateOfBirth = day + "/" + month + "/" + year;

        String email = req.getParameter("email");
        String mobile = req.getParameter("mobile");
        String gender = req.getParameter("gender");

        String address = req.getParameter("address");
        String city = req.getParameter("city");
        String pinCode = req.getParameter("pinCode");
        String state = req.getParameter("state");
        String country = req.getParameter("country");

        String[] hobbies = req.getParameterValues("hobbies");

        String board_1 = req.getParameter("board1");
        String percentage_1 = req.getParameter("percentage1");
        String year_1 = req.getParameter("year1");

        String board_2 = req.getParameter("board2");
        String percentage_2 = req.getParameter("percentage2");
        String year_2 = req.getParameter("year2");

        String board_3 = req.getParameter("board3");
        String percentage_3 = req.getParameter("percentage3");
        String year_3 = req.getParameter("year3");

        String board_4 = req.getParameter("board4");
        String percentage_4 = req.getParameter("percentage4");
        String year_4 = req.getParameter("year4");

        Qualification qualification_1 = new Qualification(board_1, percentage_1, year_1);
        Qualification qualification_2 = new Qualification(board_2, percentage_2, year_2);
        Qualification qualification_3 = new Qualification(board_3, percentage_3, year_3);
        Qualification qualification_4 = new Qualification(board_4, percentage_4, year_4);

        Qualification[] qualifications = {qualification_1, qualification_2, qualification_3, qualification_4};

        String applies = req.getParameter("applies");

        Person person = new Person(firstName, lastName, dateOfBirth, email, mobile, gender, address, city, pinCode, state, country, hobbies, qualifications, applies);

        req.setAttribute("person", person);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("result.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
