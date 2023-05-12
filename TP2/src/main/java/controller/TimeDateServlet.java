package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimeDateServlet extends HttpServlet {

	private static final long serialVersionUID = -6560473323925863865L;
	private String message;

	public void init() throws ServletException {
// Do required initialization
		message = String.valueOf("Heure " + LocalDateTime.now().getHour()) + "-"
				+ String.valueOf(LocalDateTime.now().getMinute()) + " Date " + LocalDate.now().toString();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

// Set response content type
		response.setContentType("text/html");
// Actual logic goes here.
		PrintWriter out = response.getWriter();
		out.println("<h1>" + message + "</h1>");
	}

	public void destroy() {
// do nothing.
	}
}
