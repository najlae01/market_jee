package fstt.org.market.controllers.order;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fstt.org.market.dao.OrderDAO;
import fstt.org.market.entities.Order;

@WebServlet
public class ListOrderController extends HttpServlet{

	// @Inject
	// private OrderDAO orderDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			OrderDAO orderDAO;
			try {
				orderDAO = new OrderDAO();
				List<Order> list = orderDAO.findAllOrder();
				
				request.setAttribute("list", list);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("orders.jsp").forward(request, response);

	}

}
