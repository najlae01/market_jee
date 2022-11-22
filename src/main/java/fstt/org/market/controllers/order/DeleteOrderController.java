package fstt.org.market.controllers.order;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fstt.org.market.dao.OrderDAO;

@WebServlet
public class DeleteOrderController extends HttpServlet {

	// @Inject
	// private OrderDAO orderDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		try {

			OrderDAO orderDAO;
			try {
				orderDAO = new OrderDAO();
				orderDAO.deleteOrder(id);;

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("/listOrder.do").forward(request, response);

	}
}