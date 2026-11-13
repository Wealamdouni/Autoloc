package tn.esprit.autoloc.Service;

import tn.esprit.autoloc.Entities.client;
import java.util.List;
import java.util.Set;

public interface IClientService {
    client ajouterClient(client cl);
    void supprimerClient(long idClient);
    List<client> recupererClients();
    Set<client> findClients();
    client recupererClientByid(long idClient);
}