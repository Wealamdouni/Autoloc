package tn.esprit.autoloc.Service;

import org.jspecify.annotations.Nullable;
import tn.esprit.autoloc.Entities.equipement;
import java.util.List;
import java.util.Set;

public interface IEquipementService {
    equipement ajouterEquipement(equipement eq);
    void supprimerEquipement(long idEquipement);
    List<equipement> recupererEquipements();
    Set<equipement> findEquipements();
    equipement recupererEquipementByid(long idEquipement);

    @Nullable equipement modifierEquipement(equipement equipement);
}