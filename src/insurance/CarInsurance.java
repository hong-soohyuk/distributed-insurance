package insurance;

import customer.Customer;
import customer.Property;

public class CarInsurance extends Insurance {
	@Override
	public float calculateRate(Customer customer) {
		Property property = customer.getProperty();
		long carCost = property.getCar();
		if (carCost > 0) {
			if (carCost <= 100000000) {insuranceRatio *= 1.8f;}
			else if (carCost > 100000000 && carCost <= 200000000) {insuranceRatio *= 2.0f;}
			else if (carCost > 200000000 && carCost <= Integer.MAX_VALUE) {insuranceRatio *= 2.2f;}
			else {insuranceRatio *= 2.5f;}
		}
		switch (customer.getJob()) {
			case DRIVER : insuranceRatio *= 2.6f; break;
			case UNEMPLOYED : insuranceRatio *= 1.8f; break;
			case MILITARYSERVICE : 	insuranceRatio *= 2.0f; break;
		default : break;
		}
		return insuranceRatio;
	}
}
