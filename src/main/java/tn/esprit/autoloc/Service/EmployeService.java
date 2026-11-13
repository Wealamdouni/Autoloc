package tn.esprit.autoloc.Service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.employe;
import tn.esprit.autoloc.Repositories.employeRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EmployeService implements tn.esprit.autoloc.Service.IEmployeService {
    private final employeRepository employeRepo;

    @Override
    public employe ajouterEmploye(employe em) { return employeRepo.save(em); }
    @Override
    public void supprimerEmploye(long idEmploye) { employeRepo.deleteById(idEmploye); }
    @Override
    public List<employe> recupererEmployes() { return employeRepo.findAll(); }
    @Override
    public Set<employe> findEmployes() { return new HashSet<>(employeRepo.findAll()); }
    @Override
    public employe recupererEmployeByid(long idEmploye) { return employeRepo.findById(idEmploye).orElse(null); }

    @Override
    public @Nullable employe modifierEmploye(employe employe) {
        return null;
    }
}
