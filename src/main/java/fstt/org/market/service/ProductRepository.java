package fstt.org.market.service;

import java.sql.SQLException;

import fstt.org.market.entities.Product;


public interface ProductRepository {
	
	public void saveProduct(Product product) throws SQLException;
	
	public void updateProduct(Product product) throws SQLException;
	
	public void deleteProduct(Integer id) throws SQLException;
	
	public java.util.List<Product> findAllProduct() throws SQLException;

	public Product findById(Integer id) throws SQLException;
}
