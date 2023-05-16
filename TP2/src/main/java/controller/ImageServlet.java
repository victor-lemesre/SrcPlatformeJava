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
 * Il y a un probleme de cache avec le serveur donc il faut reafraichir la page une demi dizaine de fois pour que l'image s'affiche correctement
 *
 */
@MultipartConfig
public class ImageServlet extends HttpServlet {

    
    private String cheminImage;

    @Override
    public void init() throws ServletException {
      
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
        //Récupération du nom de fichier envoyé depuis le html
        Part image = request.getPart("imageFile");
        String imageNom =  getSubmittedFileName(image);
        cheminImage = "Images/" +imageNom; 
        String cheminAbsolute = getServletContext().getRealPath(cheminImage);

       //Ecriture du binaire de l'image dans le serveur dans le dossier Images
        try (InputStream inputStream = image.getInputStream();
                OutputStream outputStream = new FileOutputStream(cheminAbsolute)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
        
        
 
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Image Display</title></head><body>");
        out.println("<h1>Image Display</h1>");
        out.println("<img src='" + request.getContextPath() + "/" + cheminImage + "' alt='Uploaded Image'>");
        out.println("</body></html>");
    }

    //Avoir le nom de l'image
    private String getSubmittedFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
