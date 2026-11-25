package tn.esprit.autoloc.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.Entities.reservation;
import java.util.List;


@Repository
public interface reservationRepository extends JpaRepository <reservation, Long> {
    List<reservation> findByClient_IdClient(Long idClient);

}
