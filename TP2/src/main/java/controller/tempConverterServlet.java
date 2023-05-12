package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class tempConverterServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("TempFormConverter.html");
		dispatcher.forward(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get the value of the Celsius parameter from the form
		double celsius = Double.parseDouble(request.getParameter("celsius"));

		// Convert the temperature from Celsius to Fahrenheit
		double fahrenheit = (celsius * 9 / 5) + 32;
		response.setContentType("text/html");

		// Write the result as HTML to the response body
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Result</title></head>");
		out.println("<body>");
		out.println("<h1>Celsius to Fahrenheit Conversion Result</h1>");
		out.println("<p>" + celsius + " degrees Celsius is equal to " + fahrenheit + " degrees Fahrenheit.</p>");
		out.println("</body></html>");
	}
}
