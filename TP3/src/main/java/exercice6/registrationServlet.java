package exercice6;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * exercice 6:
 * nous n'avons pas implementer de sauvgarde dans une BDD  
 * car nous avions deja fais ca dans le TP2
 */

public class registrationServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("viewRegistration.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Perform validation
        boolean isValid = validateRegistration(firstName, lastName, email, password);

        if (isValid) {
            // Set attributes for confirmRegistration.jsp
            request.setAttribute("firstName", firstName);
            request.setAttribute("lastName", lastName);
            request.setAttribute("email", email);
            request.setAttribute("password", password.substring(0, 3)+"...");

            // Forward to confirmRegistration.jsp
            request.getRequestDispatcher("confirmRegistration.jsp").forward(request, response);
        } else {
            // Set attributes for viewRegistration.jsp
            request.setAttribute("firstName", firstName);
            request.setAttribute("lastName", lastName);
            request.setAttribute("email", email);
            request.setAttribute("password", password);

            // Forward to checkRegistration.jsp
            request.getRequestDispatcher("checkRegistration.jsp").forward(request, response);
        }
    }
	
	private boolean validateRegistration(String firstName, String lastName, String email, String password) {
        // Perform your validation logic here
        // Return true if the data is valid, false otherwise
        return !firstName.isEmpty() && !lastName.isEmpty() && !email.isEmpty() && !password.isEmpty();
    }

}
