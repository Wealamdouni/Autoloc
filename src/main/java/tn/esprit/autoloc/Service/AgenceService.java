package tn.esprit.autoloc.Service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.agence;
import tn.esprit.autoloc.Repositories.agenceRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AgenceService implements tn.esprit.autoloc.Service.IAgenceService {
    private final agenceRepository agenceRepo;

    @Override
    public agence ajouterAgence(agence ag) { return agenceRepo.save(ag); }
    @Override
    public void supprimerAgence(long idAgence) { agenceRepo.deleteById(idAgence); }
    @Override
    public List<agence> recupererAgences() { return agenceRepo.findAll(); }
    @Override
    public Set<agence> findAgences() { return new HashSet<>(agenceRepo.findAll()); }
    @Override
    public agence recupererAgenceByid(long idAgence) { return agenceRepo.findById(idAgence).orElse(null); }

    @Override
    public @Nullable agence modifierAgence(agence agence) {
        return null;
    }
}
