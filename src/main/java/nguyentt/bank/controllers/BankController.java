package nguyentt.bank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nguyentt.bank.models.Client;
import nguyentt.bank.models.Transaction;
import nguyentt.bank.services.ClientNotFoundException;
import nguyentt.bank.services.ClientService;

@RestController
public class BankController {
	
	@Autowired
	private ClientService service;
	
	@RequestMapping(value="/clients", method=RequestMethod.GET)
	public List<Client> getClients() {
		return service.getClients();
	}
	
	@RequestMapping(value="/clients/{id}", method=RequestMethod.GET)
	public Client getFullClient(@PathVariable Long id) throws ClientNotFoundException {
		return service.findClientById(id);
	}
	@RequestMapping(value="/clients/{id}/transactions", method=RequestMethod.POST)
	public void createTransaction(@PathVariable Long id, @RequestBody Transaction transaction) throws ClientNotFoundException {
		service.saveTransaction(id, transaction);
	}
	
	@RequestMapping(value="/clients/{id}/transactions", method=RequestMethod.GET)
	public List<Transaction> getTransactions(@PathVariable Long id) throws ClientNotFoundException {
		return service.getTransactions(id);
	}
	
}
