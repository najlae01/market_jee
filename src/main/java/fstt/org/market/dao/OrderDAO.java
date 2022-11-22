package fstt.org.market.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fstt.org.market.connexion.ConnexionManager;
import fstt.org.market.entities.Client;
import fstt.org.market.entities.Order;
import fstt.org.market.service.OrderRepository;

public class OrderDAO implements OrderRepository {

	protected Connection connexion;
	protected Statement statement;
	protected PreparedStatement preparedStatement;
	protected ResultSet resultSet;

	public OrderDAO() throws SQLException, ClassNotFoundException {
		connexion = ConnexionManager.getConnexion();
	}

	@Override
	public void saveOrder(Order order) throws SQLException {
		String sql = "insert into orderc (order_date , order_client_id) values (? ,?)";

		this.preparedStatement = this.connexion.prepareStatement(sql);

		this.preparedStatement.setDate(1, new java.sql.Date(order.getOrderDate().getTime()));
		this.preparedStatement.setInt(2, order.getClient().getClientId());

		this.preparedStatement.execute();
	}

	@Override
	public void updateOrder(Order order) throws SQLException {
		String sql = "update orderc set order_date = ? , order_client_id = ? where order_id = ?";

		this.preparedStatement = this.connexion.prepareStatement(sql);
		
		this.preparedStatement.setDate(1, new java.sql.Date(order.getOrderDate().getTime()));
		this.preparedStatement.setInt(2, order.getClient().getClientId());
		this.preparedStatement.setInt(3, order.getOrderId());

		this.preparedStatement.execute();
	}

	@Override
	public void deleteOrder(Integer id) throws SQLException {
		String sql = "delete from orderc where order_id = ?";

		this.preparedStatement = this.connexion.prepareStatement(sql);

		this.preparedStatement.setInt(1, id);

		this.preparedStatement.execute();
		
	}

	@Override
	public List<Order> findAllOrder() throws SQLException, ClassNotFoundException {
		ClientDAO clientDAO = new ClientDAO();
		List<Order> list = new ArrayList<Order>();
		this.statement = this.connexion.createStatement();

		this.resultSet = this.statement.executeQuery("select * from orderc ");

		while (this.resultSet.next()) {
			Client client = clientDAO.findById(this.resultSet.getInt(3));
			System.out.println(client);
			list.add(new Order(this.resultSet.getInt(1), this.resultSet.getDate(2), client));
		}

		return list;
	}

	@Override
	public Order findById(Integer id) throws SQLException, ClassNotFoundException {
		ClientDAO clientDAO = new ClientDAO();
		String sql = "select * from orderc where order_id = ?";

		Order order = null;

		this.preparedStatement = this.connexion.prepareStatement(sql);

		this.preparedStatement.setInt(1, id);

		this.resultSet = this.preparedStatement.executeQuery();

		while (this.resultSet.next()) {
			Client client = clientDAO.findById(this.resultSet.getInt(3));
			System.out.println(client);
			order = new Order(this.resultSet.getInt(1), this.resultSet.getDate(2), client);

			break;

		}

		return order;
	}

}
