package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@WebServlet("/Upload")
@MultipartConfig(
        location = "D:\\09_ETC\\Temp",
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5
)
public class Upload extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private String uploadPath;

    @Override
    public void init() throws ServletException {
        super.init();
        uploadPath = getServletContext().getInitParameter("uploadPath");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        var out = resp.getWriter();
        try {
            for (Part part : req.getParts()) {
                var fileName = part.getSubmittedFileName();
                if (fileName == null || fileName.isEmpty()) {
                    continue;
                }

                InputStream inputStream = part.getInputStream();
                var path = Paths.get(uploadPath + File.separator + fileName);
                Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("File uploaded to: " + path);
            }
            out.println("File uploaded successfully!");
        } catch (IOException e) {
            System.err.println("Upload failed due to IOException: " + e.getMessage());
            out.println("File upload failed!");
        } catch (ServletException e) {
            System.err.println("Upload failed due to ServletException: " + e.getMessage());
            out.println("File upload failed!");
        }

    }

}
