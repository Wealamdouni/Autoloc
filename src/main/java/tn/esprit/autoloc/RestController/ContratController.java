
package tn.esprit.autoloc.RestController;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.esprit.autoloc.Entities.contrat;
import tn.esprit.autoloc.Service.IContratService;


import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/contrats")
public class ContratController {

    private final IContratService contratService;

    @PostMapping("/addcontrat")
    public ResponseEntity<contrat> ajouterContrat(@RequestBody contrat contrat) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(contratService.ajouterContrat(contrat));
    }

    @PutMapping("/{id}")
    public ResponseEntity<contrat> modifierContrat(
            @PathVariable long id,
            @RequestBody contrat contrat) {

        if (contratService.recupererContratByid(id) == null)
            return ResponseEntity.notFound().build();

        contrat.setIdContrat(id);

        return ResponseEntity.ok(contratService.modifierContrat(contrat));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerContrat(@PathVariable long id) {

        if (contratService.recupererContratByid(id) == null)
            return ResponseEntity.notFound().build();

        contratService.supprimerContrat(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<contrat>> recupererContrats() {
        return ResponseEntity.ok(contratService.recupererContrats());
    }

    @GetMapping("/{id}")
    public ResponseEntity<contrat> recupererContratById(@PathVariable long id) {

        contrat contrat = contratService.recupererContratByid(id);

        return contrat == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(contrat);
    }
}

