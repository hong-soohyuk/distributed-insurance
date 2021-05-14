package registration;

//Control Class just operation.
public class Registrator {
	
	private RegistrationList registrationList;
	public Registrator(RegistrationList registrationList) {
		this.registrationList = registrationList;
	}
	public boolean registrate(Registration registration) {
		return this.registrationList.add(registration);
	}
}
