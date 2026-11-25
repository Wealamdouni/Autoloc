
package tn.esprit.autoloc.Service;

import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import tn.esprit.autoloc.DTO.ReservationResponseDto;
import tn.esprit.autoloc.Entities.reservation;
import tn.esprit.autoloc.Mappers.ReservationMapper;
import tn.esprit.autoloc.Repositories.reservationRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ReservationService implements IReservationService {

    private final reservationRepository reservationRepo;
    private final ReservationMapper reservationMapper;

    @Override
    public reservation ajouterReservation(reservation re) {
        return reservationRepo.save(re);
    }

    @Override
    public void supprimerReservation(long idReservation) {
        reservationRepo.deleteById(idReservation);
    }

    @Override
    public List<reservation> recupererReservations() {
        return reservationRepo.findAll();
    }

    @Override
    public Set<reservation> findReservations() {
        return new HashSet<>(reservationRepo.findAll());
    }

    @Override
    public reservation recupererReservationByid(long idReservation) {
        return reservationRepo.findById(idReservation).orElse(null);
    }

    @Override
    public @Nullable reservation modifierReservation(reservation re) {
        return null;
    }

    // Scénario 2 : récupérer toutes les réservations en DTO
    @Override
    public List<ReservationResponseDto> recupererToutesLesReservations() {

        List<reservation> reservations = reservationRepo.findAll();

        return reservationMapper.toDtoList(reservations);
    }

    // Scénario 2 : récupérer les réservations d'un client
    @Override
    public List<ReservationResponseDto> recupererReservationsParClient(long idClient) {

        List<reservation> reservations =
                reservationRepo.findByClient_IdClient(idClient);

        return reservationMapper.toDtoList(reservations);
    }
}
