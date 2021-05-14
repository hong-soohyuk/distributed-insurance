package insurance;

import java.util.ArrayList;

public interface InsuranceList {
	public boolean add(Insurance insurance);
	public boolean delete(String insuranceID);
	public Insurance search(String insuranceID);
	public ArrayList<Insurance> getInsuranceList();

}
