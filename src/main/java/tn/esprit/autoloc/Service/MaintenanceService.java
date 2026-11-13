package tn.esprit.autoloc.Service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.maintenance;
import tn.esprit.autoloc.Repositories.maintenanceRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MaintenanceService implements tn.esprit.autoloc.Service.IMaintenanceService {
    private final maintenanceRepository maintenanceRepo;

    @Override
    public maintenance ajouterMaintenance(maintenance mt) { return maintenanceRepo.save(mt); }
    @Override
    public void supprimerMaintenance(long idMaintenance) { maintenanceRepo.deleteById(idMaintenance); }
    @Override
    public List<maintenance> recupererMaintenances() { return maintenanceRepo.findAll(); }
    @Override
    public Set<maintenance> findMaintenances() { return new HashSet<>(maintenanceRepo.findAll()); }
    @Override
    public maintenance recupererMaintenanceByid(long idMaintenance) { return maintenanceRepo.findById(idMaintenance).orElse(null); }

    @Override
    public @Nullable maintenance modifierMaintenance(maintenance maintenance) {
        return null;
    }
}