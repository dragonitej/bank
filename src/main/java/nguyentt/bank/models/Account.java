package nguyentt.bank.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private BigDecimal balance;
	
	@OneToMany(targetEntity=Transaction.class, fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<Transaction> transactions;
	
	public Account() {
		balance = BigDecimal.valueOf(0, 0);
		transactions = new ArrayList<>();
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
}
