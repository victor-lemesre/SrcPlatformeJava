package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * 
 * Exercice 7
 *
 */
public class ImageServlet extends HttpServlet {

    private File selectedImage;

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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("select") != null) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Select a file");
            FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG Images", "png");
            fileChooser.setFileFilter(filter);
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                selectedImage = fileChooser.getSelectedFile();
                System.out.println("Selected file: " + selectedImage.getAbsolutePath());
                RequestDispatcher dispatcher = req.getRequestDispatcher("image.html");
                dispatcher.forward(req, resp);
            }
        } else {
            if (null != selectedImage) {
                PrintWriter out = resp.getWriter();
                out.println("<html><head></head><body> " + "<img src='" + selectedImage.getAbsolutePath()
                        + "' alt='My Image'>" + "</body></html>");
            }

        }

    }
}
