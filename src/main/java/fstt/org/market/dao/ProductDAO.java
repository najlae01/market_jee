package fstt.org.market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fstt.org.market.connexion.ConnexionManager;
import fstt.org.market.entities.Product;
import fstt.org.market.service.ProductRepository;

public class ProductDAO implements ProductRepository {

	protected Connection connexion;
	protected Statement statement;
	protected PreparedStatement preparedStatement;
	protected ResultSet resultSet;

	public ProductDAO() throws SQLException, ClassNotFoundException {
		connexion = ConnexionManager.getConnexion();
	}

	@Override
	public void saveProduct(Product product) throws SQLException {
		
		String sql = "insert into product (product_name , product_description, product_price, product_stock_quantity) values (? ,?, ?, ?)";

		this.preparedStatement = this.connexion.prepareStatement(sql);

		this.preparedStatement.setString(1, product.getProductName());
		this.preparedStatement.setString(2, product.getProductDescription());
		this.preparedStatement.setDouble(3, product.getProductPrice());
		this.preparedStatement.setInt(4, product.getProductStockQuantity());

		this.preparedStatement.execute();
	}

	@Override
	public void updateProduct(Product product) throws SQLException {
		String sql = "update product set product_name = ? , product_description = ?, product_price = ?, product_stock_quantity = ? where product_id = ?";

		this.preparedStatement = this.connexion.prepareStatement(sql);
		
		this.preparedStatement.setString(1, product.getProductName());
		this.preparedStatement.setString(2, product.getProductDescription());
		this.preparedStatement.setDouble(3, product.getProductPrice());
		this.preparedStatement.setInt(4, product.getProductStockQuantity());
		this.preparedStatement.setInt(5, product.getProductId());
		
		this.preparedStatement.execute();
	}

	@Override
	public void deleteProduct(Integer id) throws SQLException {
		
		String sql = "delete from product where product_id = ?";

		this.preparedStatement = this.connexion.prepareStatement(sql);

		this.preparedStatement.setInt(1, id);

		this.preparedStatement.execute();
	}

	@Override
	public List<Product> findAllProduct() throws SQLException {
		
		List<Product> list = new ArrayList<Product>();
		this.statement = this.connexion.createStatement();

		this.resultSet = this.statement.executeQuery("select * from product ");

		while (this.resultSet.next()) {

			list.add(new Product(this.resultSet.getInt(1), this.resultSet.getString(2), this.resultSet.getString(3),
					this.resultSet.getDouble(4), this.resultSet.getInt(5)));
		}

		return list;
	}

	@Override
	public Product findById(Integer id) throws SQLException {
		String sql = "select * from product where product_id = ?";

		Product product = null;

		this.preparedStatement = this.connexion.prepareStatement(sql);

		this.preparedStatement.setInt(1, id);

		this.resultSet = this.preparedStatement.executeQuery();

		while (this.resultSet.next()) {

			product = new Product(this.resultSet.getInt(1), this.resultSet.getString(2), this.resultSet.getString(3),
					this.resultSet.getDouble(4), this.resultSet.getInt(5));

			break;

		}

		return product;
	}


}
