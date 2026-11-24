
package tn.esprit.autoloc.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.agence;
import tn.esprit.autoloc.Entities.employe;
import tn.esprit.autoloc.Repositories.agenceRepository;
import tn.esprit.autoloc.Repositories.employeRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EmployeService implements IEmployeService {

    private final employeRepository employeRepo;
    private final agenceRepository agenceRepo;

    @Override
    public employe ajouterEmploye(employe em) {
        return employeRepo.save(em);
    }

    @Override
    public void supprimerEmploye(long idEmploye) {
        employeRepo.deleteById(idEmploye);
    }

    @Override
    public List<employe> recupererEmployes() {
        return employeRepo.findAll();
    }

    @Override
    public Set<employe> findEmployes() {
        return new HashSet<>(employeRepo.findAll());
    }

    @Override
    public employe recupererEmployeByid(long idEmploye) {
        return employeRepo.findById(idEmploye).orElse(null);
    }

    @Override
    public employe modifierEmploye(employe employe) {
        return null;
    }

    // 1. DESAFFECTER UN EMPLOYE
    @Override
    public employe desaffecterEmploye(Long idEmploye) {

        employe employe = employeRepo.findById(idEmploye)
                .orElseThrow(() -> new RuntimeException("Employe introuvable"));

        employe.setAgence(null);

        return employeRepo.save(employe);
    }

    // 2. AFFECTER UN EMPLOYE A UNE AGENCE
    @Override
    public employe affecterEmploye(Long idEmploye, Long idAgence) {

        employe employe = employeRepo.findById(idEmploye)
                .orElseThrow(() -> new RuntimeException("Employe introuvable"));

        agence agence = agenceRepo.findById(idAgence)
                .orElseThrow(() -> new RuntimeException("Agence introuvable"));

        employe.setAgence(agence);

        return employeRepo.save(employe);
    }
}
