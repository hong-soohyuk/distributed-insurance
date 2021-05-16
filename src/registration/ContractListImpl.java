package registration;

import java.util.ArrayList;

public class ContractListImpl implements ContractList{

	private ArrayList<Contract> registrationList;
	
	public ContractListImpl() {
		this.setRegistrationList(new ArrayList<Contract>());
	}
	
	@Override
	public boolean add(Contract registration) {
		return this.registrationList.add(registration);
	}

	@Override
	public boolean delete(String registrationID) {
		Contract toDeleteRegistration = search(registrationID);
		if (toDeleteRegistration != null) 
			return this.registrationList.remove(toDeleteRegistration);			
		else 
			return false;
	}

	@Override
	public Contract search(String registrationID) {
		for(Contract regi : this.registrationList) {
			if(regi.getRegistrationID().equals(registrationID)) 
				return regi;
		}
		return null;
	}
	
	public ArrayList<Contract> getRegistrationList() {return this.registrationList;}
	public void setRegistrationList(ArrayList<Contract> registrationList) {this.registrationList = registrationList;}

}
