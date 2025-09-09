package cursino.guilherme.crud_clientes.mapping;

import cursino.guilherme.crud_clientes.dto.ClientDTO;
import cursino.guilherme.crud_clientes.entities.Client;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mapping(target = "id", source = "dto.id")
    Client toClientEntity(ClientDTO dto);

    @Mapping(target = "id", source = "client.id")
    ClientDTO toClientDTO(Client client);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Client updateClientFromDTO(ClientDTO dto, @MappingTarget Client client);
}
