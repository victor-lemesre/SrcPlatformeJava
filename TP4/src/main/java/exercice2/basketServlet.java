package exercice2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class basketServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("productSelection.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product = request.getParameter("product");

        HttpSession session = request.getSession();
        Map<String, Integer> selectedProducts = (Map<String, Integer>) session.getAttribute("selectedProducts");
        if (selectedProducts == null) {
            selectedProducts = new HashMap<>();
            session.setAttribute("selectedProducts", selectedProducts);
        }

        // Update the quantity for the selected product
        int quantity = selectedProducts.getOrDefault(product, 0) + 1;
        selectedProducts.put(product, quantity);

        response.sendRedirect("basket.jsp");
    }

}
