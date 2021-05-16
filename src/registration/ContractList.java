package registration;

import java.util.ArrayList;

public interface ContractList {
	public boolean add(Contract registration);
	public boolean delete(String registrationID);
	public Contract search(String registrationID);
	public ArrayList<Contract> getRegistrationList();
}
