package com.example.gestion_projet.services;

import com.example.gestion_projet.models.Tache;

import java.util.List;

public interface tacheService {

    public Tache ajouterTache(Tache t);
    public void  supprimerTache(Long id);
    public Tache getById(Long id);
    public List<Tache> listeTaches();
    public void modifierTache(Long id,Tache t);

}
