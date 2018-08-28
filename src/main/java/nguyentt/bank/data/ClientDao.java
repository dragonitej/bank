package nguyentt.bank.data;

import java.util.List;

import nguyentt.bank.models.Client;

public interface ClientDao {

	public List<Client> getClients();
	public Client findClientById();
	
	public void createClient(Client client);
	public void deleteClient(Client client);
}
