
package tn.esprit.autoloc.RestController;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.esprit.autoloc.Entities.reservation;
import tn.esprit.autoloc.Service.IReservationService;


import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/reservations")
public class ReservationController {

    private final IReservationService reservationService;

    @PostMapping("/addreservation")
    public ResponseEntity<reservation> ajouterReservation(@RequestBody reservation reservation) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(reservationService.ajouterReservation(reservation));
    }

    @PutMapping("/{id}")
    public ResponseEntity<reservation> modifierReservation(
            @PathVariable long id,
            @RequestBody reservation reservation) {

        if (reservationService.recupererReservationByid(id) == null)
            return ResponseEntity.notFound().build();

        reservation.setIdReservation(id);

        return ResponseEntity.ok(reservationService.modifierReservation(reservation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerReservation(@PathVariable long id) {

        if (reservationService.recupererReservationByid(id) == null)
            return ResponseEntity.notFound().build();

        reservationService.supprimerReservation(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<reservation>> recupererReservations() {
        return ResponseEntity.ok(reservationService.recupererReservations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<reservation> recupererReservationById(@PathVariable long id) {

        reservation reservation = reservationService.recupererReservationByid(id);

        return reservation == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(reservation);
    }
}
