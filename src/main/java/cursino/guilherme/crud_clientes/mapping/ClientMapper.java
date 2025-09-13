package cursino.guilherme.crud_clientes.mapping;

import cursino.guilherme.crud_clientes.dto.ClientDTO;
import cursino.guilherme.crud_clientes.entities.Client;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client toClientEntity(ClientDTO dto);

    ClientDTO toClientDTO(Client client);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Client updateClientFromDTO(ClientDTO dto, @MappingTarget Client client);
}
