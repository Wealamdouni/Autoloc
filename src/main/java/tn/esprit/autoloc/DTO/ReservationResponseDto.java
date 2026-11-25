
package tn.esprit.autoloc.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.autoloc.Entities.StatueReservation;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationResponseDto {

    private Long idReservation;

    private LocalDate dateDebut;
    private LocalDate dateFin;

    private StatueReservation statut;

    private String nomClient;
    private String prenomClient;

    private String marqueVehicule;
    private String modeleVehicule;
    private String immatriculationVehicule;
}
