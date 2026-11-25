
package tn.esprit.autoloc.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import tn.esprit.autoloc.DTO.ClientRequestDto;
import tn.esprit.autoloc.DTO.ClientResponseDto;
import tn.esprit.autoloc.Entities.client;
import tn.esprit.autoloc.Repositories.clientRepository;
import tn.esprit.autoloc.Mappers.ClientMapper;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ClientService implements IClientService {

    private final clientRepository clientRepo;
    private final ClientMapper clientMapper;

    @Override
    public client ajouterClient(client cl) {
        return clientRepo.save(cl);
    }

    @Override
    public void supprimerClient(long idClient) {
        clientRepo.deleteById(idClient);
    }

    @Override
    public List<client> recupererClients() {
        return clientRepo.findAll();
    }

    @Override
    public Set<client> findClients() {
        return new HashSet<>(clientRepo.findAll());
    }

    @Override
    public client recupererClientByid(long idClient) {
        return clientRepo.findById(idClient).orElse(null);
    }

    // Ajouter un client via DTO
    @Override
    public ClientResponseDto ajouterClient(ClientRequestDto dto) {

        client cl = clientMapper.toEntity(dto);

        if (cl.getEmail() != null && cl.getEmail().isBlank()) {
            cl.setEmail(null);
        }

        if (cl.getTelephone() != null && cl.getTelephone().isBlank()) {
            cl.setTelephone(null);
        }

        if (cl.getEmail() != null &&
                clientRepo.existsByEmail(cl.getEmail())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Un client avec cet email existe déjà"
            );
        }

        cl.setDateInscription(LocalDate.now());

        return clientMapper.toResponseDto(clientRepo.save(cl));
    }

    // Consulter un client via son ID
    @Override
    public ClientResponseDto consulterClient(long idClient) {

        return clientRepo.findById(idClient)
                .map(clientMapper::toResponseDto)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Client introuvable avec l'id " + idClient
                ));
    }
}
