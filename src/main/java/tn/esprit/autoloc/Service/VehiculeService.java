package tn.esprit.autoloc.Service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.Vehicule;
import tn.esprit.autoloc.Repositories.vehiculeRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class VehiculeService implements tn.esprit.autoloc.Service.IVehiculeService {
    private final vehiculeRepository vehiculeRepo;

    @Override
    public Vehicule ajouterVehicule(Vehicule ve) { return vehiculeRepo.save(ve); }
    @Override
    public void supprimerVehicule(long idVehicule) { vehiculeRepo.deleteById(idVehicule); }
    @Override
    public List<Vehicule> recupererVehicules() { return vehiculeRepo.findAll(); }
    @Override
    public Set<Vehicule> findVehicules() { return new HashSet<>(vehiculeRepo.findAll()); }
    @Override
    public Vehicule recupererVehiculeByid(long idVehicule) { return vehiculeRepo.findById(idVehicule).orElse(null); }

    @Override
    public @Nullable Vehicule modifierVehicule(Vehicule vehicule) {
        return null;
    }
}