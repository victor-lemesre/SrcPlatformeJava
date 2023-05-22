package exercice2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SquareServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        // TODO Auto-generated method stub
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Integer> List = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            List.add(i*1);
        }

        req.setAttribute("LISTE", List);
        
        RequestDispatcher dispatcher = req.getRequestDispatcher("square.jsp");
        dispatcher.forward(req, resp);

    }
}
