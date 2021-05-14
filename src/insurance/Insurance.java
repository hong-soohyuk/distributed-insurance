package insurance;
import customer.Customer;
public abstract class Insurance {
	//Attributes
	private int description;
	private String insuranceID;
	private String name;
	private int risk;
	private int type;
	protected float insuranceRatio = 1.0f;
	
	//Composition Class
	private ContractCondition contractcondition;
	public Insurance() {
		this.contractcondition = new ContractCondition();
	}
	public ContractCondition getContractcondition() {
		return contractcondition;
	}
	public void setContractcondition(ContractCondition contractcondition) {
		this.contractcondition = contractcondition;
	}
	public int getDescription() {
		return description;
	}
	public void setDescription(int description) {
		this.description = description;
	}
	public String getInsuranceID() {
		return insuranceID;
	}
	public void setInsuranceID(String insuranceID) {
		this.insuranceID = insuranceID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRisk() {
		return risk;
	}
	public void setRisk(int risk) {
		this.risk = risk;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public float getRatio() {
		return insuranceRatio;
	}
	abstract public float calculateRate(Customer customer);
	
}
