package tn.esprit.autoloc.Service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.paiement;
import tn.esprit.autoloc.Repositories.paiementRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PaiementService implements tn.esprit.autoloc.Service.IPaiementService {
    private final paiementRepository paiementRepo;

    @Override
    public paiement ajouterPaiement(paiement pa) { return paiementRepo.save(pa); }
    @Override
    public void supprimerPaiement(long idPaiement) { paiementRepo.deleteById(idPaiement); }
    @Override
    public List<paiement> recupererPaiements() { return paiementRepo.findAll(); }


    @Override
    public Set<paiement> findPaiement() { return new HashSet<>(paiementRepo.findAll()); }
    @Override
    public paiement recupererPaiementByid(long idPaiement) { return paiementRepo.findById(idPaiement).orElse(null); }

    @Override
    public paiement modifierPaiement(paiement paiement) {
        return null;
    }
}