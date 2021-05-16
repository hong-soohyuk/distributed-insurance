package registration;

import client.Client;
import commonValue.enums.approval;
import commonValue.enums.travelAreaGrade;
import insurance.Insurance;

// Entity Class , getter setter. (Value Object -> Data Transfer Object)

public class Contract {
	private String registrationID;
	private approval approv;
	private Client client;
	private Insurance insurance;
	private travelAreaGrade areaGrade;
	private float contractGrade;
	
	public Contract() {
		this.approv = approval.DENIED;
		this.contractGrade = 100.0f;
	}
	public boolean register(Client client, Insurance insurance) {
		this.setClient(client);
		this.setInsurance(insurance);
		this.registrationID = client.getCustomerID() + insurance.getInsuranceID();
		return true;
	}
	
	public approval getApproval() {	
		if(this.contractGrade >= 70) this.approv = approval.APPROVED;
		else this.approv = approval.DENIED;
		return this.approv;
	}
	
	public String getRegistrationID() {return registrationID;}
	public void setRegistrationID(String registrationID) {this.registrationID = registrationID;}
	
	public Insurance getInsurance() {return insurance;}
	public void setInsurance(Insurance insurance) {this.insurance = insurance;}
	
	public Client getClient() {return client;}
	public void setClient(Client customer) {this.client = customer;}
	
	public travelAreaGrade getAreaGrade() {return areaGrade;}
	public void setAreaGrade(travelAreaGrade areaGrade) {this.areaGrade = areaGrade;}
	
	public void calculateGrade() {this.contractGrade = this.insurance.calculateGrade(this.client);	}
	public void calculateRate() {this.insurance.calculateRate(this.client);}
	
	public float getContractGrade() {return this.contractGrade;}
	public float getInsuranceRatio() {return this.insurance.getRatio();}
}