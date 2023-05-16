package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * Exercice 4
 *
 */
public class BlogServlet extends HttpServlet {

	private String configMdp;
	private String configLogin;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		configMdp = config.getInitParameter("mdp");
		configLogin = config.getInitParameter("login");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("blog.html");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("login");
		String mdp = req.getParameter("mdp");

		if (configLogin.equals(login) && configMdp.equals(mdp)) {

			RequestDispatcher dispatcher = req.getRequestDispatcher("correct.html");
			dispatcher.forward(req, resp);
		} else {

			RequestDispatcher dispatcher = req.getRequestDispatcher("blog.html");
			dispatcher.forward(req, resp);
		}
	}
}
