
package tn.esprit.autoloc.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.autoloc.DTO.ReservationResponseDto;
import tn.esprit.autoloc.Entities.reservation;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    @Mapping(source = "client.nom", target = "nomClient")
    @Mapping(source = "client.prenom", target = "prenomClient")
    @Mapping(source = "vehicule.marque", target = "marqueVehicule")
    @Mapping(source = "vehicule.modele", target = "modeleVehicule")
    @Mapping(source = "vehicule.immatriculation", target = "immatriculationVehicule")


    List<ReservationResponseDto> toDtoList(List<reservation> reservations);
}
