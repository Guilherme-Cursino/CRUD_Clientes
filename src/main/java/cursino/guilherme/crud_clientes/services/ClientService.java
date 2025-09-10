package cursino.guilherme.crud_clientes.services;

import cursino.guilherme.crud_clientes.dto.ClientDTO;
import cursino.guilherme.crud_clientes.entities.Client;
import cursino.guilherme.crud_clientes.mapping.ClientMapper;
import cursino.guilherme.crud_clientes.repositories.ClientRepository;
import cursino.guilherme.crud_clientes.services.exceptions.DatabaseException;
import cursino.guilherme.crud_clientes.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    private final ClientRepository repository;
    private final ClientMapper mapper;

    @Autowired
    public ClientService(ClientRepository repository, ClientMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client client = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return mapper.toClientDTO(client);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> clients = repository.findAll(pageable);
        return clients.map(x -> mapper.toClientDTO(x));
    }

    @Transactional
    public ClientDTO insert(ClientDTO clientDTO) {
        Client client = mapper.toClientEntity(clientDTO);
        return mapper.toClientDTO(repository.save(client));
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO clientDTO) {
        Client existentClient = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        Client updatedClient = mapper.updateClientFromDTO(clientDTO, existentClient);
        return mapper.toClientDTO(repository.save(updatedClient));
    }

    @Transactional
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
             throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try {
            repository.deleteById(id);
        }  catch (EmptyResultDataAccessException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }
}
