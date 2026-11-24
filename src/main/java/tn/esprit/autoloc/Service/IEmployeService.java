package tn.esprit.autoloc.Service;

import org.jspecify.annotations.Nullable;
import tn.esprit.autoloc.Entities.employe;
import java.util.List;
import java.util.Set;

public interface IEmployeService {
    employe ajouterEmploye(employe em);
    void supprimerEmploye(long idEmploye);
    List<employe> recupererEmployes();
    Set<employe> findEmployes();
    employe recupererEmployeByid(long idEmploye);

    @Nullable employe modifierEmploye(employe employe);

    employe desaffecterEmploye(Long idEmploye);

    employe affecterEmploye(Long idEmploye, Long idAgence);
}
