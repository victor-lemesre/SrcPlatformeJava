package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.gradeBusiness;
import business.gradeBusinessImpl;

public class gradeServlet extends HttpServlet {

	private gradeBusiness grade;

	@Override
	public void init() throws ServletException {
		super.init();
		this.grade = new gradeBusinessImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("gradeForm.html");
		dispatcher.forward(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String firstName = request.getParameter("firstName");
		Integer studentNumber = Integer.parseInt(request.getParameter("studentNumber"));
		Double grade = Double.parseDouble(request.getParameter("grade"));

		this.grade.addGrade(name, firstName, studentNumber, grade);
		Double mean = this.grade.getMean();
		response.setContentType("text/html");

		// Write the result as HTML to the response body
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Result</title></head>");
		out.println("<body>");
		out.println("<h1>grade mean: </h1>");
		out.println("<p>" + mean + "</p>");
		out.println("</body></html>");

	}
}
