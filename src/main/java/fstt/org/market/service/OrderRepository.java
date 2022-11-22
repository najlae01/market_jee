package fstt.org.market.service;

import java.sql.SQLException;

import fstt.org.market.entities.Order;

public interface OrderRepository {
	
	public void saveOrder(Order order) throws SQLException;
	
	public void updateOrder(Order product) throws SQLException;
	
	public void deleteOrder(Integer id) throws SQLException;
	
	public java.util.List<Order> findAllOrder() throws SQLException, ClassNotFoundException;

	public Order findById(Integer id) throws SQLException, ClassNotFoundException;
}
