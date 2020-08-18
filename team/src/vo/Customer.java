package vo;

public class Customer {
	private String id;
	private String payment;
	
	public Customer() {
	}

	public Customer(String id, String payment) {
		super();
		this.id = id;
		this.payment = payment;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", payment=" + payment + "]";
	}

	
}