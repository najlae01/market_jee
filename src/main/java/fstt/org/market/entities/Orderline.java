package fstt.org.market.entities;

import java.util.List;

public class Orderline implements Cloneable{
	
	private Integer orderlineId;
	
	private int orderlineQuantity;
	
	private Order orderlineOrder;
	
	private Product orderlineProduct;

	public Orderline(Integer orderlineId, int orderlineQuantity, Order orderlineOrder, Product orderlineProduct) {
		super();
		this.orderlineId = orderlineId;
		this.orderlineQuantity = orderlineQuantity;
		this.orderlineOrder = orderlineOrder;
		this.orderlineProduct = orderlineProduct;
	}

	public Orderline(int orderlineQuantity, Order orderlineOrder, Product orderlineProduct) {
		super();
		this.orderlineQuantity = orderlineQuantity;
		this.orderlineOrder = orderlineOrder;
		this.orderlineProduct = orderlineProduct;
	}

	public Orderline(Integer orderlineId, int orderlineQuantity, Product orderlineProduct) {
		super();
		this.orderlineId = orderlineId;
		this.orderlineQuantity = orderlineQuantity;
		this.orderlineProduct = orderlineProduct;
	}

	public Orderline() {
		super();
	}

	public Integer getOrderlineId() {
		return orderlineId;
	}

	public void setOrderlineId(Integer orderlineId) {
		this.orderlineId = orderlineId;
	}

	public int getOrderlineQuantity() {
		return orderlineQuantity;
	}

	public void setOrderlineQuantity(int orderlineQuantity) {
		this.orderlineQuantity = orderlineQuantity;
	}

	public Order getOrderlineOrder() {
		return orderlineOrder;
	}

	public void setOrderlineOrder(Order orderlineOrder) {
		this.orderlineOrder = orderlineOrder;
	}

	public Product getOrderlineProduct() {
		return orderlineProduct;
	}

	public void setOrderlineProduct(Product orderlineProduct) {
		this.orderlineProduct = orderlineProduct;
	}
	
	@Override
	public String toString() {
		return "Orderline [orderlineId=" + orderlineId + ", orderlineQuantity=" + orderlineQuantity
				+ ", orderlineOrder=" + orderlineOrder + ", orderlineProduct=" + orderlineProduct + "]";
	}

}
