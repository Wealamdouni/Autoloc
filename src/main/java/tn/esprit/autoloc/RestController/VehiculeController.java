
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
public class VehiculeController {

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

    // SCENARIO 2 : Affecter un véhicule à une agence
    @PutMapping("/affecterAgence/{idVehicule}/{idAgence}")
    public ResponseEntity<Vehicule> affecterVehicule(
            @PathVariable Long idVehicule,
            @PathVariable Long idAgence) {

        return ResponseEntity.ok(
                VehiculeService.affecterVehicule(idVehicule, idAgence));
    }

    // SCENARIO 3 : Affecter un équipement à un véhicule
    @PutMapping("/affecterEquipement/{idVehicule}/{idEquipement}")
    public ResponseEntity<Vehicule> affecterEquipement(
            @PathVariable Long idVehicule,
            @PathVariable Long idEquipement) {

        return ResponseEntity.ok(
                VehiculeService.affecterEquipement(idVehicule, idEquipement));
    }

    // SCENARIO 3 : Désaffecter un équipement d'un véhicule
    @PutMapping("/desaffecterEquipement/{idVehicule}/{idEquipement}")
    public ResponseEntity<Vehicule> desaffecterEquipement(
            @PathVariable Long idVehicule,
            @PathVariable Long idEquipement) {

        return ResponseEntity.ok(
                VehiculeService.desaffecterEquipement(idVehicule, idEquipement));
    }
}
