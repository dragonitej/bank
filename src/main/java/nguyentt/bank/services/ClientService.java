package nguyentt.bank.services;

import java.util.List;

import nguyentt.bank.models.Client;
import nguyentt.bank.models.Transaction;

public interface ClientService {

	public List<Client> getClients();
	public Client findClientById(Long id) throws ClientNotFoundException;
	public void saveTransaction(Long clientId, Transaction transaction) throws ClientNotFoundException;
	public List<Transaction> getTransactions(Long clientId) throws ClientNotFoundException;
	
	public void createClient(Client client);
	public void deleteClient(Client client);
}
