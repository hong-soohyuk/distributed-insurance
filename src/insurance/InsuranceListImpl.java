package insurance;

import java.util.ArrayList;

public class InsuranceListImpl implements InsuranceList{
	private ArrayList<Insurance> insuranceList;
	public Insurance insurance;
	public InsuranceListImpl() {
		this.insuranceList = new ArrayList<Insurance>();
	}
	@Override
	public boolean add(Insurance insurance) {
		return this.insuranceList.add(insurance);
	}

	@Override
	public boolean delete(String insuranceID) {
		Insurance toDeleteInsurance = search(insuranceID);
		if (toDeleteInsurance != null) 
			return this.insuranceList.remove(toDeleteInsurance);			
		else 
			return false;
	}

	@Override
	public Insurance search(String insuranceID) {
		for(Insurance insu : this.insuranceList) {
			if(insu.getInsuranceID().equals(insuranceID)) return insu;
		}
		return null;
	}
	@Override
	public ArrayList<Insurance> getInsuranceList() {
		return this.insuranceList;
	}

}
