package exercice4;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DrawServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        // TODO Auto-generated method stub
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("random.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Random random = new Random();
        int randomNumber = random.nextInt(10) + 1;
   
        request.setAttribute("RANDOM", randomNumber);
        request.setAttribute("SELECTED",request.getParameter("choice"));
        request.getRequestDispatcher("random.jsp").forward(request, response);
      
    }
}
