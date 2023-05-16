package controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * Exercice 8
 *
 */

public class authenticationVersionAServlet implements Filter {

	private ServletContext context;

	public void init(FilterConfig config) throws ServletException {
		context = config.getServletContext();
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		// Vérifie si l'utilisateur est connecté en utilisant une session

		// L'utilisateur n'est pas connecté, redirige vers la page d'authentification
		String url = (String) request.getSession().getAttribute("originalURL");

		if (url != null) {
			// chain.doFilter(request, response);
			String pageName = getPageNameFromUrl(url) + ".html";
			request.getSession().invalidate();
			response.sendRedirect(request.getContextPath() + "/" + pageName);
			// response.sendRedirect(request.getContextPath() + "/Accueil.html");
		} else {
			request.getSession().setAttribute("originalURL", request.getRequestURL().toString());
			response.sendRedirect(request.getContextPath() + "/login.html");
		}

	}

	public void destroy() {
	}

	public String getPageNameFromUrl(String url) {
		int lastSlashIndex = url.lastIndexOf("/");
		if (lastSlashIndex == -1) {
			return url; // si l'URL ne contient pas de "/", alors on la retourne telle quelle
		} else {
			String lastPart = url.substring(lastSlashIndex + 1); // on récupère la partie après le dernier "/"
			int questionMarkIndex = lastPart.indexOf("?");
			if (questionMarkIndex != -1) {
				lastPart = lastPart.substring(0, questionMarkIndex); // on supprime la partie après le "?"
			}
			return lastPart;
		}
	}
}
