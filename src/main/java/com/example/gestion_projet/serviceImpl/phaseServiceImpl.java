package com.example.gestion_projet.serviceImpl;

import com.example.gestion_projet.models.Phase;
import com.example.gestion_projet.repository.phaseRepository;
import com.example.gestion_projet.services.phaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class phaseServiceImpl implements phaseService {

    @Autowired
    phaseRepository phaseRepository;

    @Override
    public Phase ajouterPhase(Phase ph) {
        return this.phaseRepository.save(ph);
    }

    @Override
    public void supprimerPhase(Long id) {
        this.phaseRepository.deleteById(id);
    }

    @Override
    public Phase getById(Long id) {
        Optional<Phase> phase = this.phaseRepository.findById(id);
        return phase.isPresent()?phase.get():null;
    }

    @Override
    public List<Phase> listePhases() {
        return this.phaseRepository.findAll();
    }

    @Override
    public void modifierPhase(Long id, Phase ph) {
        Phase phDb = phaseRepository.findById(id).get();
        phDb.setNom_phase(ph.getNom_phase());
        phDb.setDuree(ph.getDuree());
        phDb.setDate_debut_phase(ph.getDate_debut_phase());
        phDb.setDate_fin_phase(ph.getDate_fin_phase());
        phDb.setEtat(ph.getEtat());
        phDb.setProjet(ph.getProjet());
        System.out.println(phDb.toString());
        phaseRepository.save(phDb);
    }
}
