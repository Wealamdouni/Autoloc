package tn.esprit.autoloc.Service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.client;
import tn.esprit.autoloc.Repositories.clientRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ClientService implements tn.esprit.autoloc.Service.IClientService {
    private final clientRepository clientRepo;

    @Override
    public client ajouterClient(client cl) { return clientRepo.save(cl); }
    @Override
    public void supprimerClient(long idClient) { clientRepo.deleteById(idClient); }
    @Override
    public List<client> recupererClients() { return clientRepo.findAll(); }
    @Override
    public Set<client> findClients() { return new HashSet<>(clientRepo.findAll()); }
    @Override
    public client recupererClientByid(long idClient) { return clientRepo.findById(idClient).orElse(null); }
}