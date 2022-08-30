package com.example.gestion_projet.services;

import java.util.List;
import com.example.gestion_projet.models.Phase;

public interface phaseService {

    public Phase ajouterPhase(Phase ph);
    public void  supprimerPhase(Long id);
    public Phase getById(Long id);
    public List<Phase> listePhases();
    public void modifierPhase(Long id, Phase ph);

}
