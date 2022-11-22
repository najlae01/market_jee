package fstt.org.market.controllers.order;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fstt.org.market.dao.ClientDAO;
import fstt.org.market.dao.OrderDAO;
import fstt.org.market.dao.ProductDAO;
import fstt.org.market.entities.Client;
import fstt.org.market.entities.Order;
import fstt.org.market.entities.Product;

@WebServlet
public class SaveOrderController extends HttpServlet {

	// @Inject
	// private OrderDAO orderDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {

			ClientDAO clientDAO;
			try {
				clientDAO = new ClientDAO();
				List<Client> list = clientDAO.findAllClient();
				
				request.setAttribute("list", list);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
        request.getRequestDispatcher("addOrder.jsp").forward(request, response);;
        
        
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Order order;

		int clientId = Integer.parseInt(request.getParameter("client"));
		
		
		try {
			ClientDAO clientDAO;
			OrderDAO orderDAO;;
			try {
				clientDAO = new ClientDAO();
				Client client = clientDAO.findById(clientId);
				
				order = new Order(client);
				
				orderDAO = new OrderDAO();
				orderDAO.saveOrder(order);;

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