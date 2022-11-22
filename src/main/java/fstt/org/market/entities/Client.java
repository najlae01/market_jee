package fstt.org.market.entities;


public class Client implements Cloneable{
	
	private Integer clientId;
	
	private String clientName;
	
	private String clientAddress;
	
	private String clientPhone;
	
	private String clientCity;
	

	public Client() {
		super();
	}	

	public Client(String clientName, String clientAddress, String clientPhone, String clientCity) {
		super();
		this.clientName = clientName;
		this.clientAddress = clientAddress;
		this.clientPhone = clientPhone;
		this.clientCity = clientCity;
	}


	public Client(Integer clientId, String clientName, String clientAddress, String clientPhone, String clientCity) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.clientAddress = clientAddress;
		this.clientPhone = clientPhone;
		this.clientCity = clientCity;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientAddress() {
		return clientAddress;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	public String getClientPhone() {
		return clientPhone;
	}

	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}

	public String getClientCity() {
		return clientCity;
	}

	public void setClientCity(String clientCity) {
		this.clientCity = clientCity;
	}

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", clientName=" + clientName + ", clientAddress=" + clientAddress
				+ ", clientPhone=" + clientPhone + ", clientCity=" + clientCity + "]";
	}

	
}
