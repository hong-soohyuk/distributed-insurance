package registration;

import java.util.ArrayList;

public class RegistrationListImpl implements RegistrationList{

	private ArrayList<Registration> registrationList;
	
	public RegistrationListImpl() {
		this.setRegistrationList(new ArrayList<Registration>());
	}
	
	@Override
	public boolean add(Registration registration) {
		return this.registrationList.add(registration);
	}

	@Override
	public boolean delete(String registrationID) {
		Registration toDeleteRegistration = search(registrationID);
		if (toDeleteRegistration != null) 
			return this.registrationList.remove(toDeleteRegistration);			
		else 
			return false;
	}

	@Override
	public Registration search(String registrationID) {
		for(Registration regi : this.registrationList) {
			if(regi.getRegistrationID().equals(registrationID)) 
				return regi;
		}
		return null;
	}
	
	public ArrayList<Registration> getRegistrationList() {return this.registrationList;}
	public void setRegistrationList(ArrayList<Registration> registrationList) {this.registrationList = registrationList;}

}
