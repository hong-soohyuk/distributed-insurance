package customer;

import commonValue.enums.Age;
import commonValue.enums.job;

public class Customer {
	
	//Attributes
	private String addidentHistory;
	private Age age;
	private String customerID;
	private int familyIllHistory;
	private boolean gender;
	private int illHistory;
	private String name;
	private String phoneNo;
	private String registrationNo;
	private job job;
	
	//Composition Class
	private Property property;
	

	public Customer() {
		setProperty(new Property());
	}
	
	
	public String getAddidentHistory() {
		return addidentHistory;
	}
	public void setAddidentHistory(String addidentHistory) {
		this.addidentHistory = addidentHistory;
	}
	
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public int getFamilyIllHistory() {
		return familyIllHistory;
	}
	public void setFamilyIllHistory(int familyIllHistory) {
		this.familyIllHistory = familyIllHistory;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public int getIllHistory() {
		return illHistory;
	}
	public void setIllHistory(int illHistory) {
		this.illHistory = illHistory;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	public String getRegistrationNo() {
		return registrationNo;
	}
	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}
	public Property getProperty() {
		return property;
	}
	public void setProperty(Property property) {
		this.property = property;
	}

	public job getJob() {
		return job;
	}
	public void setJob(job job) {
		this.job = job;
	}
	public Age getAge() {
		return age;
	}
	public void setAge(int age) {
		if(age < 20) this.age = Age.TENTH;
		else if(age >= 20 && age < 30) this.age = Age.TWENTIETH;
		else if(age >= 30 && age < 40) this.age = Age.THIRTIETH;
		else if(age >= 40 && age < 50) this.age = Age.FOURTIETH;
		else if(age >= 50 && age < 60) this.age = Age.FIFTIETH;
		else if(age >= 60 && age < 70) this.age = Age.OVER_SEVENTIETH;
	}
	
}
