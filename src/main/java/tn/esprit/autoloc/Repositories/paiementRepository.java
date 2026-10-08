package tn.esprit.autoloc.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.Entities.paiement;


@Repository
public interface paiementRepository extends JpaRepository <paiement,Long > {
}
