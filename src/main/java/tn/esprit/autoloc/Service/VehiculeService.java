
package tn.esprit.autoloc.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.Vehicule;
import tn.esprit.autoloc.Entities.agence;
import tn.esprit.autoloc.Repositories.vehiculeRepository;
import tn.esprit.autoloc.Repositories.agenceRepository;
import tn.esprit.autoloc.Repositories.equipementRepository;
import tn.esprit.autoloc.Entities.equipement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class VehiculeService implements IVehiculeService {

    private final vehiculeRepository vehiculeRepo;
    private final agenceRepository agenceRepo;
    private final equipementRepository equipementRepo;

    @Override
    public Vehicule ajouterVehicule(Vehicule ve) {
        return vehiculeRepo.save(ve);
    }

    @Override
    public void supprimerVehicule(long idVehicule) {
        vehiculeRepo.deleteById(idVehicule);
    }

    @Override
    public List<Vehicule> recupererVehicules() {
        return vehiculeRepo.findAll();
    }

    @Override
    public Set<Vehicule> findVehicules() {
        return new HashSet<>(vehiculeRepo.findAll());
    }

    @Override
    public Vehicule recupererVehiculeByid(long idVehicule) {
        return vehiculeRepo.findById(idVehicule).orElse(null);
    }

    @Override
    public Vehicule modifierVehicule(Vehicule vehicule) {
        return null;
    }

    // SCENARIO 2 : AFFECTER UN VEHICULE A UNE AGENCE
    @Override
    public Vehicule affecterVehicule(Long idVehicule, Long idAgence) {

        Vehicule vehicule = vehiculeRepo.findById(idVehicule)
                .orElseThrow(() -> new RuntimeException("Vehicule introuvable"));

        agence agence = agenceRepo.findById(idAgence)
                .orElseThrow(() -> new RuntimeException("Agence introuvable"));

        vehicule.setAgence(agence);

        return vehiculeRepo.save(vehicule);
    }

    // SCENARIO 3 : AFFECTER UN EQUIPEMENT A UN VEHICULE

    @Override
    public Vehicule affecterEquipement(Long idVehicule, Long idEquipement) {

        Vehicule vehicule = vehiculeRepo.findById(idVehicule)
                .orElseThrow(() -> new RuntimeException("Vehicule introuvable"));

        equipement equipement = equipementRepo.findById(idEquipement)
                .orElseThrow(() -> new RuntimeException("Equipement introuvable"));

        vehicule.getEquipments().add(equipement);

        return vehiculeRepo.save(vehicule);
    }

    @Override
    public Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement) {

        Vehicule vehicule = vehiculeRepo.findById(idVehicule)
                .orElseThrow(() -> new RuntimeException("Vehicule introuvable"));

        equipement equipement = equipementRepo.findById(idEquipement)
                .orElseThrow(() -> new RuntimeException("Equipement introuvable"));

        vehicule.getEquipments().remove(equipement);

        return vehiculeRepo.save(vehicule);
    }

}
