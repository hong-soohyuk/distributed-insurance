package customer;

import java.util.ArrayList;

public interface CustomerList {
	public boolean add(Customer customer);
	public boolean delete(String customerID);
	public void update();
	public Customer search(String customerID);
	public ArrayList<Customer> getCustomers();
}
