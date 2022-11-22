package fstt.org.market.entities;

public class Product implements Cloneable{
	
	private Integer productId;
	
	private String productName;
	
	private String productDescription;
	
	private double productPrice;
	
	private int productStockQuantity;

	public Product() {
		super();
	}

	public Product(Integer productId, String productName, String productDescription, double productPrice,
			int productStockQuantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productStockQuantity = productStockQuantity;
	}

	public Product(String productName, String productDescription, double productPrice, int productStockQuantity) {
		super();
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productStockQuantity = productStockQuantity;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductStockQuantity() {
		return productStockQuantity;
	}

	public void setProductStockQuantity(int productStockQuantity) {
		this.productStockQuantity = productStockQuantity;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDescription="
				+ productDescription + ", productPrice=" + productPrice + ", productStockQuantity="
				+ productStockQuantity + "]";
	}
	
	
}
