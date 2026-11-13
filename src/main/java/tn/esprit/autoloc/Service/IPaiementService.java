
package tn.esprit.autoloc.Service;

import tn.esprit.autoloc.Entities.maintenance;
import tn.esprit.autoloc.Entities.paiement;
import java.util.List;
import java.util.Set;

public interface IPaiementService {

    paiement ajouterPaiement(paiement paiement);

    void supprimerPaiement(long idPaiement);

    List<paiement> recupererPaiements();

    Set<paiement> findPaiement();

    paiement recupererPaiementByid(long idPaiement);

    paiement modifierPaiement(paiement paiement);
}
