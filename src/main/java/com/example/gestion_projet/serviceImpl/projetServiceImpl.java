package com.example.gestion_projet.serviceImpl;

import com.example.gestion_projet.models.Projet;
import com.example.gestion_projet.repository.projetRepository;
import com.example.gestion_projet.services.projetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class projetServiceImpl implements projetService {

    @Autowired
    projetRepository projetRepository;

    @Override
    public Projet ajouterProjet(Projet p) {
        return this.projetRepository.save(p);
    }

    @Override
    public void supprimerProjet(Long id) {
        this.projetRepository.deleteById(id);
    }

    @Override
    public Projet getById(Long id) {
        Optional<Projet> projet= this.projetRepository.findById(id);
        return projet.isPresent()?projet.get():null;
    }

    @Override
    public List<Projet> listeProjets() {
        return this.projetRepository.findAll();
    }

    @Override
    public void modifierProjet(Long id, Projet p) {
        Projet projDb = projetRepository.findById(id).get();
        System.out.println(projDb.toString());
        projDb.setNom(p.getNom());
        projDb.setEntite(p.getEntite());
        projDb.setDescription(p.getDescription());
        projDb.setDate_debut(p.getDate_debut());
        projDb.setDate_fin(p.getDate_fin());
        projDb.setBudget(p.getBudget());
        projetRepository.save(projDb);
    }
}
