
package tn.esprit.autoloc.RestController;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.esprit.autoloc.DTO.ReservationResponseDto;
import tn.esprit.autoloc.Entities.reservation;
import tn.esprit.autoloc.Service.IReservationService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/reservations")
public class ReservationController {

    private final IReservationService reservationService;

    // Ajouter une réservation
    @PostMapping("/addreservation")
    public ResponseEntity<reservation> ajouterReservation(
            @RequestBody reservation reservation) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(reservationService.ajouterReservation(reservation));
    }

    // Modifier une réservation
    @PutMapping("/{id}")
    public ResponseEntity<reservation> modifierReservation(
            @PathVariable long id,
            @RequestBody reservation reservation) {

        if (reservationService.recupererReservationByid(id) == null)
            return ResponseEntity.notFound().build();

        reservation.setIdReservation(id);

        return ResponseEntity.ok(
                reservationService.modifierReservation(reservation));
    }

    // Supprimer une réservation
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerReservation(@PathVariable long id) {

        if (reservationService.recupererReservationByid(id) == null)
            return ResponseEntity.notFound().build();

        reservationService.supprimerReservation(id);

        return ResponseEntity.noContent().build();
    }

    // Scénario 2 : Consulter toutes les réservations en DTO
    @GetMapping
    public ResponseEntity<List<ReservationResponseDto>> recupererReservations() {

        return ResponseEntity.ok(
                reservationService.recupererToutesLesReservations());
    }

    // Scénario 2 : Consulter les réservations d'un client
    @GetMapping("/client/{idClient}")
    public ResponseEntity<List<ReservationResponseDto>> recupererReservationsParClient(
            @PathVariable long idClient) {

        return ResponseEntity.ok(
                reservationService.recupererReservationsParClient(idClient));
    }

    // Consulter une réservation par son ID
    @GetMapping("/{id}")
    public ResponseEntity<reservation> recupererReservationById(
            @PathVariable long id) {

        reservation reservation =
                reservationService.recupererReservationByid(id);

        return reservation == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(reservation);
    }
}
