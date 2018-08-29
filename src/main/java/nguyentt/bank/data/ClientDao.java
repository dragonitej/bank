package nguyentt.bank.data;

import java.util.List;

import nguyentt.bank.models.Client;
import nguyentt.bank.models.Transaction;

public interface ClientDao {

	public List<Client> getClients();
	public Client findClientById(Long id);
	public void saveTransaction(Long clientId, Transaction transaction);
	public List<Transaction> getTransactions(Long clientId);
	
	public void createClient(Client client);
	public void deleteClient(Client client);
}
