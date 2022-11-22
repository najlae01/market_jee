package fstt.org.market.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import fstt.org.market.connexion.ConnexionManager;
import fstt.org.market.entities.Client;
import fstt.org.market.service.ClientRepository;

@ApplicationScoped
public class ClientDAO implements ClientRepository {

	protected Connection connexion;
	protected Statement statement;
	protected PreparedStatement preparedStatement;
	protected ResultSet resultSet;

	public ClientDAO() throws SQLException, ClassNotFoundException {
		connexion = ConnexionManager.getConnexion();
	}

	@Override
	public void saveClient(Client client) throws SQLException {

		String sql = "insert into client (client_name , client_address, client_phone, client_city) values (? ,?, ?, ?)";

		this.preparedStatement = this.connexion.prepareStatement(sql);

		this.preparedStatement.setString(1, client.getClientName());
		this.preparedStatement.setString(2, client.getClientAddress());
		this.preparedStatement.setString(3, client.getClientPhone());
		this.preparedStatement.setString(4, client.getClientCity());

		this.preparedStatement.execute();

	}

	@Override
	public void updateClient(Client client) throws SQLException {

		String sql = "update client set client_name = ? , client_address = ?, client_phone = ?, client_city = ? where client_id = ?";

		this.preparedStatement = this.connexion.prepareStatement(sql);

		this.preparedStatement.setString(1, client.getClientName());
		this.preparedStatement.setString(2, client.getClientAddress());
		this.preparedStatement.setString(3, client.getClientPhone());
		this.preparedStatement.setString(4, client.getClientCity());
		this.preparedStatement.setInt(5, client.getClientId());

		this.preparedStatement.execute();

	}

	@Override
	public void deleteClient(Integer id) throws SQLException {

		String sql = "delete from client where client_id = ?";

		this.preparedStatement = this.connexion.prepareStatement(sql);

		this.preparedStatement.setInt(1, id);

		this.preparedStatement.execute();

	}

	@Override
	public List<Client> findAllClient() throws SQLException {

		List<Client> list = new ArrayList<Client>();
		this.statement = this.connexion.createStatement();

		this.resultSet = this.statement.executeQuery("select * from client ");

		while (this.resultSet.next()) {

			list.add(new Client(this.resultSet.getInt(1), this.resultSet.getString(2), this.resultSet.getString(3),
					this.resultSet.getString(4), this.resultSet.getString(5)));
		}

		return list;
	}

	@Override
	public Client findById(Integer id) throws SQLException {

		String sql = "select * from client where client_id = ?";

		Client client = null;

		this.preparedStatement = this.connexion.prepareStatement(sql);

		this.preparedStatement.setInt(1, id);

		this.resultSet = this.preparedStatement.executeQuery();

		while (this.resultSet.next()) {

			client = new Client(this.resultSet.getInt(1), this.resultSet.getString(2), this.resultSet.getString(3),
					this.resultSet.getString(4), this.resultSet.getString(5));

			break;

		}

		return client;
	}

}