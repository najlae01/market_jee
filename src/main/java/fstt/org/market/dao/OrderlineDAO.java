package fstt.org.market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fstt.org.market.connexion.ConnexionManager;

import fstt.org.market.entities.Order;
import fstt.org.market.entities.Orderline;
import fstt.org.market.entities.Product;
import fstt.org.market.service.OrderlineRepository;

public class OrderlineDAO implements OrderlineRepository {

	protected Connection connexion;
	protected Statement statement;
	protected PreparedStatement preparedStatement;
	protected ResultSet resultSet;

	public OrderlineDAO() throws SQLException, ClassNotFoundException {
		connexion = ConnexionManager.getConnexion();
	}

	@Override
	public void saveOrderline(Orderline orderline) throws SQLException {
		String sql = "insert into orderline (orderline_quantity , orderline_order_id, orderline_product_id) values (? ,?, ?)";

		this.preparedStatement = this.connexion.prepareStatement(sql);

		this.preparedStatement.setInt(1, orderline.getOrderlineQuantity());
		this.preparedStatement.setInt(2, orderline.getOrderlineOrder().getOrderId());
		this.preparedStatement.setInt(3, orderline.getOrderlineProduct().getProductId());
		
		this.preparedStatement.execute();
	}

	@Override
	public void updateOrderline(Orderline orderline) throws SQLException {
		
		String sql = "update orderline set orderline_quantity = ?, orderline_order_id = ? , orderline_product_id = ? where orderline_id = ?";

		this.preparedStatement = this.connexion.prepareStatement(sql);
		
		this.preparedStatement.setInt(1, orderline.getOrderlineQuantity());
		this.preparedStatement.setInt(2, orderline.getOrderlineOrder().getOrderId());
		this.preparedStatement.setInt(3, orderline.getOrderlineProduct().getProductId());
		this.preparedStatement.setInt(4, orderline.getOrderlineId());

		this.preparedStatement.execute();
	}

	@Override
	public void deleteOrderline(Integer id) throws SQLException {
		
		String sql = "delete from orderline where orderline_id = ?";

		this.preparedStatement = this.connexion.prepareStatement(sql);

		this.preparedStatement.setInt(1, id);

		this.preparedStatement.execute();
	}

	@Override
	public List<Orderline> findAllOrderline() throws SQLException, ClassNotFoundException {
		OrderDAO orderDAO = new OrderDAO();
		ProductDAO productDAO = new ProductDAO();
		List<Orderline> list = new ArrayList<Orderline>();
		this.statement = this.connexion.createStatement();

		this.resultSet = this.statement.executeQuery("select * from orderline ");

		while (this.resultSet.next()) {
			Order order = orderDAO.findById(this.resultSet.getInt(3));
			System.out.println(order);
			Product product = productDAO.findById(this.resultSet.getInt(4));
			System.out.println(order);
			list.add(new Orderline(this.resultSet.getInt(1), this.resultSet.getInt(2), order , product));
		}

		return list;
	}

	@Override
	public Orderline findById(Integer id) throws SQLException, ClassNotFoundException {
		OrderDAO orderDAO = new OrderDAO();
		ProductDAO productDAO = new ProductDAO();
		String sql = "select * from orderline where orderline_id = ?";

		Orderline orderline = null;

		this.preparedStatement = this.connexion.prepareStatement(sql);

		this.preparedStatement.setInt(1, id);

		this.resultSet = this.preparedStatement.executeQuery();

		while (this.resultSet.next()) {
			Order order = orderDAO.findById(this.resultSet.getInt(3));
			System.out.println(order);
			Product product = productDAO.findById(this.resultSet.getInt(4));
			System.out.println(order);
			orderline = new Orderline(this.resultSet.getInt(1), this.resultSet.getInt(2), order , product);

			break;

		}

		return orderline;
	}

}
