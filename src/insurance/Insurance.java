package insurance;
import client.Client;
import commonValue.enums.insuranceType;
public abstract class Insurance {
	//Attributes
	private int description;
	private String insuranceID;
	private String name;
	private int risk;
	private insuranceType type;
	protected float insuranceRatio = 1.0f;
	protected float contractGrade = 100.0f;
	
	//Composition Class
	private ContractCondition contractcondition;
	public Insurance() {this.contractcondition = new ContractCondition();}
	public ContractCondition getContractcondition() {return contractcondition;}
	public void setContractcondition(ContractCondition contractcondition) {this.contractcondition = contractcondition;}
	
	public int getDescription() {return description;}
	public void setDescription(int description) {this.description = description;}
	
	public String getInsuranceID() {return insuranceID;}
	public void setInsuranceID(String insuranceID) {this.insuranceID = insuranceID;}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public int getRisk() {return risk;}
	public void setRisk(int risk) {this.risk = risk;}
	
	public insuranceType getType() {return type;}
	public void setType(insuranceType type) {this.type = type;}
	
	abstract public float calculateRate(Client customer);
	abstract public float calculateGrade(Client customer);
	public float getRatio() {return insuranceRatio;}
	
}
