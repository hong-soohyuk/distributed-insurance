package insurance;

import client.Client;
import commonValue.enums.insuranceType;

public class TravellerInsurance extends Insurance{
	public TravellerInsurance() {
		this.setType(insuranceType.TRAVELLER);
	}
	@Override
	public float calculateRate(Client client) {
		switch(client.getAge()) {
			case TENTH : this.insuranceRatio *= 1.3f; break;
			case TWENTIETH : this.insuranceRatio *= 1.2f; break;
			case THIRTIETH : this.insuranceRatio *= 1.2f; break;
			case FOURTIETH : this.insuranceRatio *= 1.2f; break;
			case FIFTIETH : this.insuranceRatio *= 1.3f; break;
			case SIXTIETH : this.insuranceRatio *= 1.4f; break;
			case OVER_SEVENTIETH : this.insuranceRatio *= 1.5f; break;
		}
		
		switch (client.getAreaGrade()) {
			case FIRST : this.insuranceRatio *= 1.3f; break;	
			case SECOND : this.insuranceRatio *= 1.6f; break;
			case THIRD : this.insuranceRatio *= 1.9f; break;
			case FOURTH : this.insuranceRatio *= 3.0f; break;
			case SPECIAL : this.insuranceRatio *= 2.0f; break;
		default : break;
		}
		return this.insuranceRatio;
	}
	
	@Override
	public float calculateGrade(Client client) {
		switch(client.getAge()) {
		case TENTH : this.contractGrade *= 0.9f; break;
		case TWENTIETH : this.contractGrade *= 0.95f; break;
		case THIRTIETH : this.contractGrade *= 0.9f; break;
		case FOURTIETH : this.contractGrade *= 0.9f; break;
		case FIFTIETH : this.contractGrade *= 0.85f; break;
		case SIXTIETH : this.contractGrade *= 0.8f; break;
		case OVER_SEVENTIETH : this.contractGrade *= 0.8f; break;
	}
	
	switch (client.getAreaGrade()) {
		case FIRST : this.contractGrade *= 0.95f; break;	
		case SECOND : this.contractGrade *= 0.9f; break;
		case THIRD : this.contractGrade *= 0.8f; break;
		case FOURTH : this.contractGrade *= 0.0f; break;
		case SPECIAL : this.contractGrade *= 0.0f; break;
	default : break;
	}
	return this.contractGrade;
	}
}
