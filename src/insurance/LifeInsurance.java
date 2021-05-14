package insurance;

import customer.Customer;

public class LifeInsurance extends Insurance{
	
	@Override
	public float calculateRate(Customer customer) {
		switch(customer.getJob()) {
			case DRIVER : insuranceRatio *= 1.2f; break;
			case UNEMPLOYED : insuranceRatio *= 1.1f; break;
			case MILITARYSERVICE : insuranceRatio *= 1.4f; break;
		default: break;
		}
		
		switch(customer.getAge()) {
			case TENTH : insuranceRatio *= 1.1f; break;
			case TWENTIETH : insuranceRatio *= 1.2f; break;
			case THIRTIETH : insuranceRatio *= 1.3; break;
			case FOURTIETH : insuranceRatio *= 1.4f; break;
			case FIFTIETH : insuranceRatio *= 1.6f; break;
			case SIXTIETH : insuranceRatio *= 1.7f; break;
			case OVER_SEVENTIETH : insuranceRatio *= 1.8f; break;
		}
		
		int illHistory = customer.getIllHistory();
		if(illHistory < 0) {return insuranceRatio;}
		else{
				if(illHistory == 0) {insuranceRatio *= 1.1f;}
				else if(illHistory >= 1 && illHistory <= 5) {insuranceRatio *= 1.2f;}
				else if(illHistory >= 6 && illHistory <= 10) {insuranceRatio *= 1.4f;}
				else {insuranceRatio *= 1.5f;}
				}
		return insuranceRatio;
	}

}
