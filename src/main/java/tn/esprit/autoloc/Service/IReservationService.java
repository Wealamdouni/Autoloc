package tn.esprit.autoloc.Service;

import org.jspecify.annotations.Nullable;
import tn.esprit.autoloc.Entities.reservation;
import java.util.List;
import java.util.Set;

public interface IReservationService {
    reservation ajouterReservation(reservation re);
    void supprimerReservation(long idReservation);
    List<reservation> recupererReservations();
    Set<reservation> findReservations();
    reservation recupererReservationByid(long idReservation);

    @Nullable reservation modifierReservation(reservation re);
}