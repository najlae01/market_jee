package fstt.org.market.controllers.orderline;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import fstt.org.market.dao.OrderlineDAO;
import fstt.org.market.entities.Orderline;

@WebServlet
public class ListOrderlineController extends HttpServlet{

	// @Inject
	// private OrderDAO orderDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			OrderlineDAO orderlineDAO;
			try {
				orderlineDAO = new OrderlineDAO();
				List<Orderline> list = orderlineDAO.findAllOrderline();
				
				request.setAttribute("list", list);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("orderlines.jsp").forward(request, response);

	}

}
