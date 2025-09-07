package cursino.guilherme.crud_clientes.controllers;

import cursino.guilherme.crud_clientes.dto.ClientDTO;
import cursino.guilherme.crud_clientes.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    private final ClientService service;

    @Autowired
    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping
    public Page<ClientDTO> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping(value = "/{id}")
    public ClientDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ClientDTO insert(@RequestBody ClientDTO dto){
        return service.insert(dto);
    }
}
