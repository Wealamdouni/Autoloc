package tn.esprit.autoloc.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.Entities.maintenance;


@Repository
public interface maintenanceRepository extends JpaRepository <maintenance, Long> {
}
