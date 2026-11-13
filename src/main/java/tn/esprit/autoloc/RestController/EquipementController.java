
package tn.esprit.autoloc.RestController;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.esprit.autoloc.Entities.equipement;
import tn.esprit.autoloc.Service.IEquipementService;


import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/equipements")
public class EquipementController {

    private final IEquipementService equipementService;

    @PostMapping("/addequipement")
    public ResponseEntity<equipement> ajouterEquipement(@RequestBody equipement equipement) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(equipementService.ajouterEquipement(equipement));
    }

    @PutMapping("/{id}")
    public ResponseEntity<equipement> modifierEquipement(
            @PathVariable long id,
            @RequestBody equipement equipement) {

        if (equipementService.recupererEquipementByid(id) == null)
            return ResponseEntity.notFound().build();

        equipement.setIdEquipement(id);

        return ResponseEntity.ok(equipementService.modifierEquipement(equipement));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerEquipement(@PathVariable long id) {

        if (equipementService.recupererEquipementByid(id) == null)
            return ResponseEntity.notFound().build();

        equipementService.supprimerEquipement(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<equipement>> recupererEquipements() {
        return ResponseEntity.ok(equipementService.recupererEquipements());
    }

    @GetMapping("/{id}")
    public ResponseEntity<equipement> recupererEquipementById(@PathVariable long id) {

        equipement equipement = equipementService.recupererEquipementByid(id);

        return equipement == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(equipement);
    }
}
