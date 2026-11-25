package tn.esprit.autoloc.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.autoloc.DTO.ClientRequestDto;
import tn.esprit.autoloc.DTO.ClientResponseDto;
import tn.esprit.autoloc.Entities.client;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    // DTO -> entité : les champs non exposés par le DTO sont gérés par le service / la BD
    @Mapping(target = "idClient", ignore = true)
    @Mapping(target = "numPermis", ignore = true)
    @Mapping(target = "dateInscription", ignore = true)
    @Mapping(target = "reservations", ignore = true)
    client toEntity(ClientRequestDto dto);

    // entité -> DTO : idClient est exposé sous le nom "id"
    @Mapping(source = "idClient", target = "id")
    ClientResponseDto toResponseDto(client entity);
}