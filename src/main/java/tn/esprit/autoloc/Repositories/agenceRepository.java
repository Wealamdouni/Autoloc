package tn.esprit.autoloc.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.Entities.agence;

@Repository
public interface agenceRepository extends JpaRepository<agence,Long> {
}
