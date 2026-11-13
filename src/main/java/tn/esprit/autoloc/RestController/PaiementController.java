
package tn.esprit.autoloc.RestController;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.esprit.autoloc.Entities.paiement;
import tn.esprit.autoloc.Service.IPaiementService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/paiements")
public class PaiementController {

    private final IPaiementService PaiementService;

    @PostMapping("/addpaiement")
    public ResponseEntity<paiement> ajouterPaiement(@RequestBody paiement paiement) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(PaiementService.ajouterPaiement(paiement));
    }

    @PutMapping("/{id}")
    public ResponseEntity<paiement> modifierPaiement(
            @PathVariable long id,
            @RequestBody paiement paiement) {

        if (PaiementService.recupererPaiementByid(id) == null)
            return ResponseEntity.notFound().build();

        paiement.setIdPaiement(id);

        return ResponseEntity.ok(PaiementService.modifierPaiement(paiement));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerPaiement(@PathVariable long id) {

        if (PaiementService.recupererPaiementByid(id) == null)
            return ResponseEntity.notFound().build();

        PaiementService.supprimerPaiement(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<paiement>> recupererPaiements() {
        return ResponseEntity.ok(PaiementService.recupererPaiements());
    }

    @GetMapping("/{id}")
    public ResponseEntity<paiement> recupererPaiementById(@PathVariable long id) {

        paiement paiement = PaiementService.recupererPaiementByid(id);

        return paiement == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(paiement);
    }
}
