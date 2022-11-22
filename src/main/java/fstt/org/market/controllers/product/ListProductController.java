package fstt.org.market.controllers.product;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fstt.org.market.dao.ProductDAO;
import fstt.org.market.entities.Product;

@WebServlet
public class ListProductController extends HttpServlet{

	// @Inject
	// private ProductDAO productDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			ProductDAO productDAO;
			try {
				productDAO = new ProductDAO();
				List<Product> list = productDAO.findAllProduct();
				
				request.setAttribute("list", list);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("products.jsp").forward(request, response);

	}

}
