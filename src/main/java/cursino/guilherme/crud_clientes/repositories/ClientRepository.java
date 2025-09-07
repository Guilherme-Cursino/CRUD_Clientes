package cursino.guilherme.crud_clientes.repositories;

import cursino.guilherme.crud_clientes.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
