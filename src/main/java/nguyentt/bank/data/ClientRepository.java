package nguyentt.bank.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nguyentt.bank.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
