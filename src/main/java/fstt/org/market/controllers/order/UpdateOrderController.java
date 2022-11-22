package fstt.org.market.controllers.order;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fstt.org.market.dao.ClientDAO;
import fstt.org.market.dao.OrderDAO;
import fstt.org.market.entities.Client;
import fstt.org.market.entities.Order;

@WebServlet
public class UpdateOrderController extends HttpServlet {
	// @Inject
	// private OrderDAO orderDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));


		try {
			ClientDAO clientDAO;
			OrderDAO orderDAO;

			try {
				clientDAO = new ClientDAO();
				orderDAO = new OrderDAO();
				List<Client> list = clientDAO.findAllClient();
				
				
				request.setAttribute("list", list);
				
				Order orderExists = orderDAO.findById(id);

				//request.setAttribute("oldDate", orderExists.getOrderDate());

				request.setAttribute("oldClientId", orderExists.getClient().getClientId());

				request.setAttribute("oldClientName", orderExists.getClient().getClientName());
				
				request.setAttribute("id", orderExists.getOrderId());
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("updateOrder.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Order order;


		/*Date date = null;
		try {
			date = java.text.DateFormat.getInstance().parse(request.getParameter("date"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/


		int clientId = Integer.parseInt(request.getParameter("client"));
		
		Integer id = Integer.parseInt(request.getParameter("id"));


		try {
			ClientDAO clientDAO;
			OrderDAO orderDAO;
			try {
				clientDAO = new ClientDAO();
				orderDAO = new OrderDAO();
				
				Client client = clientDAO.findById(clientId);
				order = new Order(id, client);
				
				orderDAO.updateOrder(order);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("welcome.jsp").forward(request, response);

	}

}
