
package tn.esprit.autoloc.RestController;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.esprit.autoloc.Entities.maintenance;
import tn.esprit.autoloc.Service.IMaintenanceService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/maintenances")
public class MaintenanceController {

    private final IMaintenanceService maintenanceService;

    @PostMapping("/addmaintenance")
    public ResponseEntity<maintenance> ajouterMaintenance(@RequestBody maintenance maintenance) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(maintenanceService.ajouterMaintenance(maintenance));
    }

    @PutMapping("/{id}")
    public ResponseEntity<maintenance> modifierMaintenance(
            @PathVariable long id,
            @RequestBody maintenance maintenance) {

        if (maintenanceService.recupererMaintenanceByid(id) == null)
            return ResponseEntity.notFound().build();

        maintenance.setIdMaintenance(id);

        return ResponseEntity.ok(maintenanceService.modifierMaintenance(maintenance));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerMaintenance(@PathVariable long id) {

        if (maintenanceService.recupererMaintenanceByid(id) == null)
            return ResponseEntity.notFound().build();

        maintenanceService.supprimerMaintenance(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<maintenance>> recupererMaintenances() {
        return ResponseEntity.ok(maintenanceService.recupererMaintenances());
    }

    @GetMapping("/{id}")
    public ResponseEntity<maintenance> recupererMaintenanceById(@PathVariable long id) {

        maintenance maintenance = maintenanceService.recupererMaintenanceByid(id);

        return maintenance == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(maintenance);
    }
}
