package tn.esprit.autoloc.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.DTO.ClientRequestDto;
import tn.esprit.autoloc.DTO.ClientResponseDto;
import tn.esprit.autoloc.Entities.client;
import tn.esprit.autoloc.Service.IClientService;
import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/api/clients")
public class ClientController {
    private final IClientService clientService;

    // POST /api/clients
    @PostMapping("/ajoutDTO")
    public ResponseEntity<ClientResponseDto> ajouterClient(@Valid @RequestBody ClientRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.ajouterClient(dto));
    }


    @PostMapping("/addclient")
    public ResponseEntity<client> ajouterClient(@RequestBody client cl) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.ajouterClient(cl));
    }

    @PutMapping("/{id}")
    public ResponseEntity<client> modifierClient(@PathVariable long id, @RequestBody client cl) {
        if (clientService.recupererClientByid(id) == null) return ResponseEntity.notFound().build();
        cl.setIdClient(id);
        return ResponseEntity.ok(clientService.ajouterClient(cl));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerClient(@PathVariable long id) {
        if (clientService.recupererClientByid(id) == null) return ResponseEntity.notFound().build();
        clientService.supprimerClient(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<client>> recupererClients() {
        return ResponseEntity.ok(clientService.recupererClients());
    }

    @GetMapping("/set")
    public ResponseEntity<Set<client>> findClients() {
        return ResponseEntity.ok(clientService.findClients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<client> recupererClientByid(@PathVariable long id) {
        client cl = clientService.recupererClientByid(id);
        return cl == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(cl);
    }
}
