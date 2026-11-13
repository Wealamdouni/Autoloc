
package tn.esprit.autoloc.RestController;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.esprit.autoloc.Entities.employe;
import tn.esprit.autoloc.Service.IEmployeService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employes")
public class EmployeController {

    private final IEmployeService employeService;

    @PostMapping("/addemploye")
    public ResponseEntity<employe> ajouterEmploye(@RequestBody employe employe) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(employeService.ajouterEmploye(employe));
    }

    @PutMapping("/{id}")
    public ResponseEntity<employe> modifierEmploye(
            @PathVariable long id,
            @RequestBody employe employe) {

        if (employeService.recupererEmployeByid(id) == null)
            return ResponseEntity.notFound().build();

        employe.setIdEmploye(id);

        return ResponseEntity.ok(employeService.modifierEmploye(employe));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerEmploye(@PathVariable long id) {

        if (employeService.recupererEmployeByid(id) == null)
            return ResponseEntity.notFound().build();

        employeService.supprimerEmploye(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<employe>> recupererEmployes() {
        return ResponseEntity.ok(employeService.recupererEmployes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<employe> recupererEmployeById(@PathVariable long id) {

        employe employe = employeService.recupererEmployeByid(id);

        return employe == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(employe);
    }
}
