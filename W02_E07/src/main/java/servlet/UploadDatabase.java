package servlet;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/UploadDatabase")
@MultipartConfig(location = "D:\\09_ETC\\Temp", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class UploadDatabase extends HttpServlet {

    private static final int BUFFER_SIZE = 4096;

    private static final String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=WWW_W02_E07;encrypt=true;trustServerCertificate=true;";
    private static final String dbUser = "Developer";
    private static final String dbPass = "123";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var firstName = req.getParameter("firstName");
        var lastName = req.getParameter("lastName");

        InputStream inputStream = null;
        String fileUploadName = null;

        Part part = req.getPart("photo");
        if (part != null) {
            fileUploadName = part.getName();
            inputStream = part.getInputStream();
        }

        String message = null;
        Connection connection = null;

        var filePath = "D:\\09_ETC\\Temp\\" + fileUploadName + "_" + firstName + "_" + lastName + ".png";

        try {
            DriverManager.registerDriver(new SQLServerDriver());
            connection = DriverManager.getConnection(dbURL, dbUser, dbPass);

            var sql = "INSERT INTO contacts (first_name, last_name, photo) values (?, ?, ?)";
            var statement = connection.prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, lastName);

            if (inputStream != null) {
                statement.setBlob(3, inputStream);
            }

            int row = statement.executeUpdate();
            if (row > 0) {
                message = "File uploaded and saved into database.";
            }

            // Read database and save file
            var sql_read = "SELECT photo FROM contacts WHERE first_name = ? AND last_name = ?";
            var statement_read = connection.prepareStatement(sql_read);
            statement_read.setString(1, firstName);
            statement_read.setString(2, lastName);

            var resultSet = statement_read.executeQuery();
            if (resultSet.next()) {
                var blob = resultSet.getBlob("photo");
                var inputStreamRead = blob.getBinaryStream();
                var outputStreamRead = new FileOutputStream(filePath);

                int bytesRead;
                byte[] buffer = new byte[BUFFER_SIZE];
                while ((bytesRead = inputStreamRead.read(buffer)) != -1) {
                    outputStreamRead.write(buffer, 0, bytesRead);
                }

                inputStreamRead.close();
                outputStreamRead.close();
            }

        } catch (SQLException e) {
            message = "ERROR: " + e.getMessage();
            e.printStackTrace(System.err);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace(System.err);
                }
            }
        }

        req.setAttribute("Message", message);
        getServletContext().getRequestDispatcher("/Message").forward(req, resp);
    }
}
