package fstt.org.market.connexion;

import java.sql.SQLException;

import javax.inject.Inject;

import fstt.org.market.dao.ClientDAO;
import fstt.org.market.entities.Client;
import fstt.org.market.service.ClientRepository;

public class Test {

	public static void main(String[] args)
			throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

		ClientDAO clientDAO = new ClientDAO();
		/*
		 * Client et = new Client("najlae", "Boukhalef", "0890", "Tanger");
		 * 
		 * 
		 * clientDAO.saveClient(et);
		 */

		for (Client ettmp : clientDAO.findAllClient()) {

			System.out.println(ettmp.toString());

		}

		clientDAO.deleteClient(32);

		for (Client ettmp : clientDAO.findAllClient()) {

			System.out.println(ettmp.toString());

		}
	}
}
