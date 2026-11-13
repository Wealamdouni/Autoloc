package tn.esprit.autoloc.Service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.contrat;
import tn.esprit.autoloc.Repositories.contratRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ContratService implements tn.esprit.autoloc.Service.IContratService {
    private final contratRepository contratRepo;

    @Override
    public contrat ajouterContrat(contrat ct) { return contratRepo.save(ct); }
    @Override
    public void supprimerContrat(long idContrat) { contratRepo.deleteById(idContrat); }
    @Override
    public List<contrat> recupererContrats() { return contratRepo.findAll(); }
    @Override
    public Set<contrat> findContrats() { return new HashSet<>(contratRepo.findAll()); }
    @Override
    public contrat recupererContratByid(long idContrat) { return contratRepo.findById(idContrat).orElse(null); }

    @Override
    public @Nullable contrat modifierContrat(contrat contrat) {
        return null;
    }
}