package insurance;

import java.util.Date;

public class ContractCondition {
	private Date duraction;
	
	
	private int ID;
	private int paymentAmount;
	public ContractCondition() {
		// TODO Auto-generated constructor stub
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public Date getDuraction() {
		return duraction;
	}
	public void setDuraction(Date duraction) {
		this.duraction = duraction;
	}
}
