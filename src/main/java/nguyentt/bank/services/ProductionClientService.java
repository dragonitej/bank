package nguyentt.bank.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nguyentt.bank.data.ClientRepository;
import nguyentt.bank.models.Client;
import nguyentt.bank.models.Transaction;

@Service
public class ProductionClientService implements ClientService{
	
	private final ClientRepository repository;
	
	@Autowired
	public ProductionClientService(ClientRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Client> getClients() {
		return repository.findAll();
	}

	@Override
	public Client findClientById(Long id) throws ClientNotFoundException {
		return repository.findById(id).orElseThrow(() -> new ClientNotFoundException());
	}

	@Override
	public void saveTransaction(Long clientId, Transaction transaction) throws ClientNotFoundException {
		Client client = findClientById(clientId);
		transaction.setDate(new Date());
		client.getAccount().getTransactions().add(transaction);
		repository.save(client);		
	}

	@Override
	public List<Transaction> getTransactions(Long clientId) throws ClientNotFoundException {
		Client client = findClientById(clientId);
		return client.getAccount().getTransactions();
	}

	@Override
	public void createClient(Client client) {
		repository.save(client);		
	}

	@Override
	public void deleteClient(Client client) {
		repository.delete(client);
	}


}
