package com.example.gestion_projet.services;

import java.util.List;
import com.example.gestion_projet.models.Projet;

public interface projetService {

    public Projet ajouterProjet(Projet p);
    public void  supprimerProjet(Long id);
    public Projet getById(Long id);
    public List<Projet> listeProjets();
    public void modifierProjet(Long id,Projet p);

}