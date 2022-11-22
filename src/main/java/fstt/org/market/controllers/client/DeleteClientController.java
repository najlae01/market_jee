package fstt.org.market.controllers.client;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fstt.org.market.dao.ClientDAO;

@WebServlet
public class DeleteClientController extends HttpServlet {

	// @Inject
	// private ClientDAO clientDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		try {

			ClientDAO clientDAO;
			try {
				clientDAO = new ClientDAO();
				clientDAO.deleteClient(id);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("/listClient.do").forward(request, response);

	}
}
