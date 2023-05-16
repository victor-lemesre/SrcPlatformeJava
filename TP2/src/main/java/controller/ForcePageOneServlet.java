package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * Exercice 9
 *
 */
public class ForcePageOneServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        Cookie[] cookies = request.getCookies();
        Boolean dejaVenu = false;
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                System.out.print(cookie.getName() + " - " + cookie.getValue() + "\n");
                if ("id_nom_site".equals(cookie.getName())) {
                    dejaVenu = true;
                }
            }
        }

        if (!dejaVenu) {
            String id = new String("123");
            Cookie myCookie = new Cookie("dejavisiter", id);
            myCookie.setMaxAge(240);
            response.addCookie(myCookie);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("pageone.html");
        dispatcher.forward(request, response);
    }
}
