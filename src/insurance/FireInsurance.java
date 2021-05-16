package insurance;

import client.Client;
import client.Property;
import commonValue.enums.insuranceType;

public class FireInsurance extends Insurance{
	public FireInsurance() {
		this.setType(insuranceType.FIRE);
	}
	@Override
	public float calculateRate(Client client) {
		Property property = client.getProperty();
		long houseCost = property.getHouse();
		if(houseCost  > 0){
			if(houseCost <=100000000) {this.insuranceRatio *= 1.5f;}
			else if(houseCost > 100000000 && houseCost <= 200000000) {this.insuranceRatio *= 1.8f;}
			else if(houseCost > 200000000 && houseCost <= Integer.MAX_VALUE) {this.insuranceRatio *= 2.2f;}
			else {this.insuranceRatio *= 2.5f;}
		}
		
		return this.insuranceRatio;
	}
	@Override
	public float calculateGrade(Client client) {
		Property property = client.getProperty();
		long houseCost = property.getHouse();
		if(houseCost  > 0){
			if(houseCost <=100000000) {this.contractGrade *= 0.8f;}
			else if(houseCost > 100000000 && houseCost <= 200000000) {this.contractGrade *= 0.85f;}
			else if(houseCost > 200000000 && houseCost <= Integer.MAX_VALUE) {this.contractGrade *= 0.9f;}
			else {this.contractGrade *= 0.9f;}
		}
		return this.contractGrade;
	}
	
	
}
