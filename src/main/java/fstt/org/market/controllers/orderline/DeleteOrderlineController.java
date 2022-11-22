package fstt.org.market.controllers.orderline;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fstt.org.market.dao.OrderlineDAO;

@WebServlet
public class DeleteOrderlineController  extends HttpServlet {

	// @Inject
	// private OrderlineDAO orderlineDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		try {

			OrderlineDAO orderlineDAO;
			try {
				orderlineDAO = new OrderlineDAO();
				orderlineDAO.deleteOrderline(id);;

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("/listOrderline.do").forward(request, response);

	}
}