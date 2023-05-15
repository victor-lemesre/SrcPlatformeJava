package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * 
 * Exercice 7
 *
 */
@MultipartConfig
public class ImageServlet extends HttpServlet {

    private File selectedImage;
    private String imagePath;

    @Override
    public void init() throws ServletException {
        selectedImage = null;
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("image.html");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Part imagePart = request.getPart("imageFile");
        String imageName = getSubmittedFileName(imagePart);
        imagePath = imageName; // Relative path to save the image
        String absolutePath = getServletContext().getRealPath(imagePath);

        // Save the image to the server
        try (InputStream inputStream = imagePart.getInputStream();
                OutputStream outputStream = new FileOutputStream(absolutePath)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }

        System.out.println(request.getContextPath() + "/" + imagePath);
        
        // Generate the HTML response with the image display
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Image Display</title></head><body>");
        out.println("<h1>Image Display</h1>");
        out.println("<img src='" + request.getContextPath() + "/" + imagePath + "' alt='Uploaded Image'>");
        out.println("</body></html>");
    }

    private String getSubmittedFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
