package servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/Register")
public class Register extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().println("Served at: " + req.getContextPath());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        var writer = resp.getWriter();

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String facebook = req.getParameter("facebook");
        String shortBio = req.getParameter("shortBio");

        var out = "<div>" + "Congratulations " + firstName + " " + lastName + ", you have successfully registered!" + "</div>"
                + "<div>" + "Your information: "
                + "<div>" + "Username: " + username + "</div>"
                + "<div>" + "Email: " + email + "</div>"
                + "<div>" + "Password: " + "<i>hidden</i>" + "</div>"
                + "<div>" + "Facebook: " + facebook + "</div>"
                + "<div>" + "Short Bio: " + shortBio + "</div>"
                + "</div>";

        writer.println(out);
    }
}
