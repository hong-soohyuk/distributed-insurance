package insurance;

import client.Client;
import commonValue.enums.insuranceType;

public class DriverInsurance extends Insurance{
	
	public DriverInsurance() {
		this.setType(insuranceType.DRIVER);
	}
	
	@Override
	public float calculateRate(Client client) {
		switch(client.getJob()) {
			case DRIVER : this.insuranceRatio *= 1.8f; break;// 운송업 기사
			case SERVICE_DRIVER : this.insuranceRatio *= 1.7f; break; //	서비스직 (운전)
			case SERVICE_TRAVEL : this.insuranceRatio *= 1.2f; break; // 서비스직 (여행)
			case UNEMPLOYED : this.insuranceRatio *= 1.2f; break; //	주부 및 기타 비경제활동 
			case ETC_OFFICEWORKER : this.insuranceRatio *= 1.3f; break; // 기타사무직 
			case ETC_BLUECOLLAR : this.insuranceRatio *= 1.5f; break; //	기타생산직 
		default: break;
		}
		
		switch(client.getAge()) {
			case TENTH : this.insuranceRatio *= 1.6f; break;
			case TWENTIETH : this.insuranceRatio *= 1.7f; break;
			case THIRTIETH : this.insuranceRatio *= 1.5; break;
			case FOURTIETH : this.insuranceRatio *= 1.5f; break;
			case FIFTIETH : this.insuranceRatio *= 1.7f; break;
			case SIXTIETH : this.insuranceRatio *= 1.7f; break;
			case OVER_SEVENTIETH : this.insuranceRatio *= 1.8f; break;
		}
		
		int accidentHistory = client.getAddidentHistory();
		if (accidentHistory > 0) {
			if (accidentHistory <= 3) {this.insuranceRatio *= 1.4f;}
			else if (accidentHistory > 3 && accidentHistory <= 5) {this.insuranceRatio *= 1.8f;}
			else if (accidentHistory > 5 && accidentHistory <= 10) {this.insuranceRatio *= 2.2f;}
			else {this.insuranceRatio *= 2.5f;}
		}
		
		int drivingExperience = client.getDrivingExperience();
		if (drivingExperience > 0) {
			if (drivingExperience <= 3) {this.insuranceRatio *= 1.8f;}
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
		
		switch(client.getAge()) {
			case TENTH : this.contractGrade *= 0.9f; break;
			case TWENTIETH : this.contractGrade *= 0.94f; break;
			case THIRTIETH : this.contractGrade *= 0.95; break;
			case FOURTIETH : this.contractGrade *= 0.96f; break;
			case FIFTIETH : this.contractGrade *= 0.92f; break;
			case SIXTIETH : this.contractGrade *= 0.9f; break;
			case OVER_SEVENTIETH : this.contractGrade *= 0.88f; break;
		}
	
		int accidentHistory = client.getAddidentHistory();
		if (accidentHistory > 0) {
			if (accidentHistory <= 3) {this.contractGrade *= 0.9f;}//
			else if (accidentHistory > 3 && accidentHistory <= 5) {this.contractGrade *= 0.8f;}
			else if (accidentHistory > 5 && accidentHistory <= 10) {this.contractGrade *= 0.75f;}
			else {this.contractGrade *= 0.73f;}
		}
		return this.contractGrade;
}
	

}
