package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * Exercice 5
 *
 */
public class calculateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("calculator.html");
		dispatcher.forward(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Get the values of the input parameters from the form
		double num1 = Double.parseDouble(request.getParameter("num1"));
		double num2 = Double.parseDouble(request.getParameter("num2"));
		String operation = request.getParameter("operation");

		// Calculate the result based on the selected operation
		double result = 0;
		switch (operation) {
		case "add":
			result = num1 + num2;
			break;
		case "sub":
			result = num1 - num2;
			break;
		case "mul":
			result = num1 * num2;
			break;
		case "div":
			result = num1 / num2;
			break;
		}

		// Set the content type of the response
		response.setContentType("text/html");

		// Write the result as HTML to the response body
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Result</title></head>");
		out.println("<body>");
		out.println("<h1>Calculator Result</h1>");
		out.println("<p>The result of the operation is: " + result + "</p>");
		out.println("</body></html>");
	}
}
