package tn.esprit.autoloc.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.Entities.employe;


@Repository
public interface employeRepository extends JpaRepository<employe, Long > {
}
