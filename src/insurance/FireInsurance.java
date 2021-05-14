package insurance;

import customer.Customer;
import customer.Property;

public class FireInsurance extends Insurance{
	@Override
	public float calculateRate(Customer customer) {
		Property property = customer.getProperty();
		long houseCost = property.getHouse();
		if(houseCost  > 0){
			if(houseCost <=100000000) {	insuranceRatio *= 1.5f;}
			else if(houseCost > 100000000 && houseCost <= 200000000) {	insuranceRatio *= 1.8f;}
			else if(houseCost > 200000000 && houseCost <= Integer.MAX_VALUE) {	insuranceRatio *= 2.2f;}
			else {insuranceRatio *= 2.5f;}
		}
			return insuranceRatio;
	}
}
