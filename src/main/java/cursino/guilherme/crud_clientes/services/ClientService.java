package cursino.guilherme.crud_clientes.services;

import cursino.guilherme.crud_clientes.dto.ClientDTO;
import cursino.guilherme.crud_clientes.entities.Client;
import cursino.guilherme.crud_clientes.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    private final ClientRepository repository;

    @Autowired
    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client client = repository.findById(id).get();
        return new ClientDTO(client);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> clients = repository.findAll(pageable);
        return clients.map(x -> new ClientDTO(x));
    }

    @Transactional
    public ClientDTO insert(ClientDTO clientDTO) {
        Client client = new Client(
                clientDTO.getId(),
                clientDTO.getName(),
                clientDTO.getCpf(),
                clientDTO.getIncome(),
                clientDTO.getBirthDate(),
                clientDTO.getChildren()
        );
        return new ClientDTO(repository.save(client));
    }
}
