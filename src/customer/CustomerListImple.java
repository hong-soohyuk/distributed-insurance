package customer;
import java.util.ArrayList;

public class CustomerListImple implements CustomerList{
	private ArrayList<Customer> customerList;
	
	public CustomerListImple() {
		this.customerList = new ArrayList<Customer>();
	}
	
	@Override
	public boolean add(Customer customer) 
	{
		if(this.customerList.add(customer))
			return true;
		else
			return false;
	}

	@Override
	public boolean delete(String customerID)
	{
		Customer toDeleteCustomer = search(customerID);
		if (toDeleteCustomer != null) 
			return this.customerList.remove(toDeleteCustomer);			
		else 
			return false;
	}

	@Override
	public void update() {}

	public Customer search(String customerID)
	{
		for(Customer cust : this.customerList) {
			if(cust.getCustomerID().equals(customerID)) return cust;
		}
		return null;
	}
	
	public void setcustomerList(ArrayList<Customer> customerList){
		this.customerList = customerList;
	}

	@Override
	public ArrayList<Customer> getCustomers() {
		return customerList;
	}
}
