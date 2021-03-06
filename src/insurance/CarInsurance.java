package insurance;

import client.Client;
import client.Property;
import commonValue.enums.insuranceType;

public class CarInsurance extends Insurance {
	public CarInsurance() {
		this.setType(insuranceType.CAR);
	}
	@Override
	public float calculateRate(Client client) {
		Property property = client.getProperty();
		long carCost = property.getCar();
		if (carCost > 0) {
			if (carCost <= 100000000) {this.insuranceRatio *= 1.8f;}//
			else if (carCost > 100000000 && carCost <= 200000000) {this.insuranceRatio *= 2.0f;}
			else if (carCost > 200000000 && carCost <= Integer.MAX_VALUE) {this.insuranceRatio *= 2.2f;}
			else {this.insuranceRatio *= 2.5f;}
		}
		switch (client.getJob()) {
			case DRIVER : this.insuranceRatio *= 1.8f; break;// 운송업 기사
			case SERVICE_DRIVER : this.insuranceRatio *= 1.7f; break; //	서비스직 (운전)
			case SERVICE_TRAVEL : this.insuranceRatio *= 1.2f; break; // 서비스직 (여행)
			case UNEMPLOYED : this.insuranceRatio *= 1.2f; break; //	주부 및 기타 비경제활동 
			case ETC_OFFICEWORKER : this.insuranceRatio *= 1.3f; break; // 기타사무직 
			case ETC_BLUECOLLAR : this.insuranceRatio *= 1.5f; break; //	기타생산직 
		default : break;
		}
		
		int drivingExperience = client.getDrivingExperience();
		if (drivingExperience >= 0) {
			if (drivingExperience <= 3) {this.insuranceRatio *= 1.8f;}//
			else if (drivingExperience > 3 && drivingExperience <= 5) {this.insuranceRatio *= 1.6f;}
			else if (drivingExperience > 5 && drivingExperience <= 10) {this.insuranceRatio *= 1.4f;}
			else {this.insuranceRatio *= 1.2f;}
		}
		return this.insuranceRatio;
	}
	
	@Override
	public float calculateGrade(Client client) {
		switch (client.getJob()) {
			case DRIVER : this.contractGrade *= 0.95f; break;// 운송업 기사
			case SERVICE_DRIVER : this.contractGrade *= 0.94f; break; //	서비스직 (운전)
			case SERVICE_TRAVEL : this.contractGrade *= 0.98f; break; // 서비스직 (여행)
			case UNEMPLOYED : this.contractGrade *= 0.9f; break; //	주부 및 기타 비경제활동 
			case ETC_OFFICEWORKER : this.contractGrade *= 0.98f; break; // 기타사무직 
			case ETC_BLUECOLLAR : this.contractGrade *= 0.95f; break; //	기타생산직 
		default : break;	
	}
		int drivingExperience = client.getDrivingExperience();
		if (drivingExperience >= 0) {
			if (drivingExperience <= 3) {this.contractGrade *= 0.8f;}//
			else if (drivingExperience > 3 && drivingExperience <= 5) {this.contractGrade *= 0.82f;}
			else if (drivingExperience > 5 && drivingExperience <= 10) {this.contractGrade *= 0.84f;}
			else {this.contractGrade *= 0.85f;}
		}
		return this.contractGrade;
	}
}