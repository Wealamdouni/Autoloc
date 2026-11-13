
package tn.esprit.autoloc.RestController;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.esprit.autoloc.Entities.agence;
import tn.esprit.autoloc.Service.IAgenceService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/agences")
public class AgenceController {

    private final IAgenceService agenceService;

    @PostMapping("/addagence")
    public ResponseEntity<agence> ajouterAgence(@RequestBody agence agence) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(agenceService.ajouterAgence(agence));
    }

    @PutMapping("/{id}")
    public ResponseEntity<agence> modifierAgence(
            @PathVariable long id,
            @RequestBody agence agence) {

        if (agenceService.recupererAgenceByid(id) == null)
            return ResponseEntity.notFound().build();

        agence.setIdAgence(id);

        return ResponseEntity.ok(agenceService.modifierAgence(agence));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerAgence(@PathVariable long id) {

        if (agenceService.recupererAgenceByid(id) == null)
            return ResponseEntity.notFound().build();

        agenceService.supprimerAgence(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<agence>> recupererAgences() {
        return ResponseEntity.ok(agenceService.recupererAgences());
    }

    @GetMapping("/{id}")
    public ResponseEntity<agence> recupererAgenceById(@PathVariable long id) {

        agence agence = agenceService.recupererAgenceByid(id);

        return agence == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(agence);
    }
}
