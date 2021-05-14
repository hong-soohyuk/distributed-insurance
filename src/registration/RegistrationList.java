package registration;

import java.util.ArrayList;

public interface RegistrationList {
	public boolean add(Registration registration);
	public boolean delete(String registrationID);
	public Registration search(String registrationID);
	public ArrayList<Registration> getRegistrationList();
}
