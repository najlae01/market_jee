package fstt.org.market.entities;

import java.util.Date;

public class Order  implements Cloneable{
	
	private Integer orderId;
	
	private Date orderDate;
	
	private Client client;

	public Order(Integer orderId, Client client) {
		super();
		this.orderId = orderId;
		this.orderDate = new Date();
		this.client = client;
	}

	public Order(Integer orderId, Date orderDate, Client client) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.client = client;
	}

	public Order(Client client) {
		super();
		this.orderDate = new Date();
		this.client = client;
	}

	public Order() {
		super();
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", client=" + client + "]";
	}
	
	
}
