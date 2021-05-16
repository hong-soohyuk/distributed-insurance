package client;

import java.util.ArrayList;

public interface ClientList {
	public boolean add(Client customer);
	public boolean delete(String customerID);
	public void update();
	public Client search(String customerID);
	public ArrayList<Client> getCustomers();
}
