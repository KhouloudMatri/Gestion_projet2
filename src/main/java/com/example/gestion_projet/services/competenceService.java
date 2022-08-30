package com.example.gestion_projet.services;

import java.util.List;
import com.example.gestion_projet.models.Competence;


public interface competenceService {

    public Competence ajouterCompetence(Competence c);
    public void  supprimerCompetence(Long id);
    public Competence getById(Long id);
    public List<Competence> listeCompetences();
    public void modifierCompetence(Long id, Competence c);
}



