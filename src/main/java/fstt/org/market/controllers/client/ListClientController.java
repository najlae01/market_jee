package fstt.org.market.controllers.client;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fstt.org.market.dao.ClientDAO;
import fstt.org.market.entities.Client;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/listClient.do")
public class ListClientController extends HttpServlet{

	// @Inject
	// private ClientDAO clientDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// request.getServletContext().getRequestDispatcher("/").forward(request,
		// response);
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
		request.getRequestDispatcher("clients.jsp").forward(request, response);

	}

}
