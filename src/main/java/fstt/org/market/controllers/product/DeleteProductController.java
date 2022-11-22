package fstt.org.market.controllers.product;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fstt.org.market.dao.ClientDAO;
import fstt.org.market.dao.ProductDAO;

@WebServlet
public class DeleteProductController extends HttpServlet {

	// @Inject
	// private ProductDAO productDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		try {

			ProductDAO productDAO;
			try {
				productDAO = new ProductDAO();
				productDAO.deleteProduct(id);;

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("/listProduct.do").forward(request, response);

	}
}
