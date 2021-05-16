package client;
import java.util.ArrayList;

public class ClientListImple implements ClientList{
	private ArrayList<Client> customerList;
	
	public ClientListImple() {
		this.customerList = new ArrayList<Client>();
	}
	
	@Override
	public boolean add(Client customer) 
	{
		if(this.customerList.add(customer))
			return true;
		else
			return false;
	}

	@Override
	public boolean delete(String customerID)
	{
		Client toDeleteCustomer = search(customerID);
		if (toDeleteCustomer != null) 
			return this.customerList.remove(toDeleteCustomer);			
		else 
			return false;
	}

	@Override
	public void update() {}

	public Client search(String customerID)
	{
		for(Client cust : this.customerList) {
			if(cust.getCustomerID().equals(customerID)) return cust;
		}
		return null;
	}
	
	public void setcustomerList(ArrayList<Client> customerList){
		this.customerList = customerList;
	}

	@Override
	public ArrayList<Client> getCustomers() {
		return customerList;
	}
}
