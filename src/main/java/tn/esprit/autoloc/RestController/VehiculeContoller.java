
package tn.esprit.autoloc.RestController;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Vehicule;
import tn.esprit.autoloc.Service.IVehiculeService;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/vehicules")
class VehiculeController {

    private final IVehiculeService VehiculeService;

    @PostMapping("/addvehicule")
    public ResponseEntity<Vehicule> ajouterVehicule(@RequestBody Vehicule vehicule) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(VehiculeService.ajouterVehicule(vehicule));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicule> modifierVehicule(
            @PathVariable long id,
            @RequestBody Vehicule vehicule) {

        if (VehiculeService.recupererVehiculeByid(id) == null)
            return ResponseEntity.notFound().build();

        vehicule.setIdVehicule(id);

        return ResponseEntity.ok(VehiculeService.modifierVehicule(vehicule));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerVehicule(@PathVariable long id) {

        if (VehiculeService.recupererVehiculeByid(id) == null)
            return ResponseEntity.notFound().build();

        VehiculeService.supprimerVehicule(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Vehicule>> recupererVehicules() {
        return ResponseEntity.ok(VehiculeService.recupererVehicules());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicule> recupererVehiculeById(@PathVariable long id) {

        Vehicule vehicule = VehiculeService.recupererVehiculeByid(id);

        return vehicule == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(vehicule);
    }
}
