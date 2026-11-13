package tn.esprit.autoloc.Service;

import org.jspecify.annotations.Nullable;
import tn.esprit.autoloc.Entities.contrat;
import java.util.List;
import java.util.Set;

public interface IContratService {
    contrat ajouterContrat(contrat ct);
    void supprimerContrat(long idContrat);
    List<contrat> recupererContrats();
    Set<contrat> findContrats();
    contrat recupererContratByid(long idContrat);

    @Nullable contrat modifierContrat(contrat contrat);
}