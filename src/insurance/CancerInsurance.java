package insurance;

import customer.Customer;

public class CancerInsurance extends Insurance{
	
	@Override
	public float calculateRate(Customer customer) {
		
		switch(customer.getAge()) {
			case TENTH : insuranceRatio *= 1.1f; break;
			case TWENTIETH : insuranceRatio *= 1.2f; break;
			case THIRTIETH : insuranceRatio *= 1.3f; break;
			case FOURTIETH : insuranceRatio *= 1.4f; break;
			case FIFTIETH : insuranceRatio *= 1.6f; break;
			case SIXTIETH : insuranceRatio *= 1.7f; break;
			case OVER_SEVENTIETH : insuranceRatio *= 1.8f; break;
		}
		int familyIllHistory = customer.getFamilyIllHistory();
		if(familyIllHistory < 0) {return insuranceRatio;}
		else
		{
			if(familyIllHistory == 0) {insuranceRatio *= 1.1f;}
			else if(familyIllHistory >= 1 && familyIllHistory <= 5) {insuranceRatio *= 1.2f;}
			else if(familyIllHistory >= 6 && familyIllHistory <= 10) {insuranceRatio *= 1.4f;}
			else {insuranceRatio *= 1.5f;}
		}
		
		int illHistory = customer.getIllHistory();
		if(illHistory < 0) {return insuranceRatio;}
		else
		{
			if(illHistory == 0) {insuranceRatio *= 1.1f;}
			else if(illHistory >= 1 && illHistory <= 5) {insuranceRatio *= 1.2f;}
			else if(illHistory >= 6 && illHistory <= 10) {insuranceRatio *= 1.4f;}
			else {insuranceRatio *= 1.5f;}
		}
		return insuranceRatio;
	}
}
