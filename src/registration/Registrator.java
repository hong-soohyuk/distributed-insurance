package registration;

//Control Class just operation.
public class Registrator {
	private ContractList registrationList;
	public Registrator(ContractList registrationList) {this.registrationList = registrationList;}
	public boolean register(Contract registration) {return this.registrationList.add(registration);}
}
