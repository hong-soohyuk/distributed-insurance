package registration;

import commonValue.enums.approval;
import customer.Customer;
import insurance.Insurance;

// Entity Class , getter setter. (Value Object -> Data Transter Object)
public class Registration {
	private String registrationID;
	private approval approv;
	private Customer customer;
	private Insurance insurance;
	
	public Registration() {
		this.approv = approval.DENIED;
	}
	public boolean register(Customer customer, Insurance insurance) {
		this.setCustomer(customer);
		this.setInsurance(insurance);
		this.registrationID = customer.getCustomerID() + insurance.getInsuranceID();
		return true;
	}
	public String getRegistrationID() {
		return registrationID;
	}
	public void setRegistrationID(String registrationID) {
		this.registrationID = registrationID;
	}
	public approval getApproval() {
		if(insurance.getRatio() <= 10) {
			this.approv = approval.APPROVED;
		}else
			this.approv = approval.DENIED;
		return this.approv;
	}
	public Insurance getInsurance() {
		return insurance;
	}
	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
