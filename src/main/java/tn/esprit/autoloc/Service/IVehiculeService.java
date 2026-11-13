package tn.esprit.autoloc.Service;

import org.jspecify.annotations.Nullable;
import tn.esprit.autoloc.Entities.Vehicule;
import java.util.List;
import java.util.Set;

public interface IVehiculeService {
    Vehicule ajouterVehicule(Vehicule ve);
    void supprimerVehicule(long idVehicule);
    List<Vehicule> recupererVehicules();
    Set<Vehicule> findVehicules();
    Vehicule recupererVehiculeByid(long idVehicule);

    @Nullable Vehicule modifierVehicule(Vehicule vehicule);
}