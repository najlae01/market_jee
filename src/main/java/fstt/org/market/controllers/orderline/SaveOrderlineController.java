package fstt.org.market.controllers.orderline;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fstt.org.market.dao.OrderDAO;
import fstt.org.market.dao.OrderlineDAO;
import fstt.org.market.dao.ProductDAO;
import fstt.org.market.entities.Order;
import fstt.org.market.entities.Orderline;
import fstt.org.market.entities.Product;

@WebServlet
public class SaveOrderlineController extends HttpServlet {

	// @Inject
	// private OrderlineDAO orderlineDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {

			ProductDAO productDAO;
			OrderDAO orderDAO;
			try {
				orderDAO = new OrderDAO();
				List<Order> orders = orderDAO.findAllOrder();
				
				productDAO = new ProductDAO();
				List<Product> products = productDAO.findAllProduct();
				
				request.setAttribute("products", products);
				request.setAttribute("orders", orders);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
        request.getRequestDispatcher("addOrderline.jsp").forward(request, response);;
        
        
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Orderline orderline;

		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		int productId = Integer.parseInt(request.getParameter("product"));
		
		int orderId = Integer.parseInt(request.getParameter("order"));
		
		try {
			ProductDAO productDAO;
			OrderDAO orderDAO;
			OrderlineDAO orderlineDAO;
			try {
				orderDAO = new OrderDAO();
				Order order = orderDAO.findById(orderId);
				
				productDAO = new ProductDAO();
				Product product = productDAO.findById(productId);
				
				orderline = new Orderline(quantity, order, product);
				
				orderlineDAO = new OrderlineDAO();
				orderlineDAO.saveOrderline(orderline);;

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