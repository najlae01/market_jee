package fstt.org.market.service;

import java.sql.SQLException;
import java.util.List;

import fstt.org.market.entities.Orderline;

public interface OrderlineRepository {
	
	public void saveOrderline(Orderline orderline) throws SQLException, ClassNotFoundException;
	
	public void updateOrderline(Orderline orderline) throws SQLException;
	
	public void deleteOrderline(Integer id) throws SQLException;
	
	public java.util.List<Orderline> findAllOrderline() throws SQLException, ClassNotFoundException;

	public Orderline findById(Integer id) throws SQLException, ClassNotFoundException;

	List<Orderline> findAllByOrderId(Integer id) throws SQLException, ClassNotFoundException;
}
