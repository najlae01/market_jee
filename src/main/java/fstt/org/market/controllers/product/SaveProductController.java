package fstt.org.market.controllers.product;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fstt.org.market.dao.ProductDAO;
import fstt.org.market.entities.Product;

@WebServlet
public class SaveProductController extends HttpServlet {

	// @Inject
	// private ProductDAO productDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
        request.getRequestDispatcher("addProduct.jsp").forward(request, response);;
        
        
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Product product;

		String name = request.getParameter("name");

		String description = request.getParameter("description");

		double price = Double.parseDouble(request.getParameter("price"));

		int quantity = Integer.parseInt(request.getParameter("quantity"));

		product = new Product(name, description, price, quantity);

		try {

			ProductDAO productDAO;
			try {
				productDAO = new ProductDAO();
				productDAO.saveProduct(product);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
        request.getRequestDispatcher("welcome.jsp").forward(request, response);;
        
        
	}

}