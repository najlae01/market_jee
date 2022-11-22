package fstt.org.market.controllers.client;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fstt.org.market.dao.ClientDAO;
import fstt.org.market.entities.Client;

@WebServlet("/saveClient.do")
public class SaveClientController extends HttpServlet {

	// @Inject
	// private ClientDAO clientDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
        request.getRequestDispatcher("addClient.jsp").forward(request, response);;
        
        
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Client client;

		String name = request.getParameter("name");

		String address = request.getParameter("address");

		String phone = request.getParameter("phone");

		String city = request.getParameter("city");

		client = new Client(name, address, phone, city);

		try {

			ClientDAO clientDAO;
			try {
				clientDAO = new ClientDAO();
				clientDAO.saveClient(client);

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
