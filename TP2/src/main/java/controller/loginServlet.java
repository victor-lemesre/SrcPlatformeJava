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
 * Exercice 8
 *
 */
public class loginServlet extends HttpServlet {

	private String configMdp;
	private String configLogin;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		configMdp = config.getInitParameter("mdp");
		configLogin = config.getInitParameter("login");

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("login.html");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String login = req.getParameter("login");
		String mdp = req.getParameter("mdp");

		String originalURL = (String) req.getSession().getAttribute("originalURL");

		if (doLogin(login, mdp, req, resp)) {
			if (originalURL != null) {
				resp.sendRedirect(originalURL);
			} else {
				// Rediriger vers une page par défaut si l'URL de la page d'origine n'a pas été
				// trouvée dans la session
				resp.sendRedirect("Accueil.html");
			}
		}

	}

	private Boolean doLogin(String login, String mdp, HttpServletRequest req, HttpServletResponse resp) {
		if (configLogin.equals(login) && configMdp.equals(mdp)) {

			return true;
		} else {

			return false;
		}
	}

}
