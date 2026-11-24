package tn.esprit.autoloc.Service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.equipement;
import tn.esprit.autoloc.Repositories.equipementRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EquipementService implements tn.esprit.autoloc.Service.IEquipementService {
    private final equipementRepository equipementRepo;

    @Override
    public equipement ajouterEquipement(equipement eq) { return equipementRepo.save(eq); }
    @Override
    public void supprimerEquipement(long idEquipement) { equipementRepo.deleteById(idEquipement); }
    @Override
    public List<equipement> recupererEquipements() { return equipementRepo.findAll(); }
    @Override
    public Set<equipement> findEquipements() { return new HashSet<>(equipementRepo.findAll()); }
    @Override
    public equipement recupererEquipementByid(long idEquipement) { return equipementRepo.findById(idEquipement).orElse(null); }

    @Override
    public @Nullable equipement modifierEquipement(equipement equipement) {
        return null;
    }

}