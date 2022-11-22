package fstt.org.market.service;

import java.sql.SQLException;

import fstt.org.market.entities.Client;

public interface ClientRepository {
	
	public void saveClient(Client client) throws SQLException;
	
	public void updateClient(Client client) throws SQLException;
	
	public void deleteClient(Integer id) throws SQLException;
	
	public java.util.List<Client> findAllClient() throws SQLException;

	public Client findById(Integer id) throws SQLException;
}
