package com.example.gestion_projet.serviceImpl;

import com.example.gestion_projet.models.Tache;
import com.example.gestion_projet.repository.tacheRepository;
import com.example.gestion_projet.services.tacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class tacheServiceImpl implements tacheService {

    @Autowired
    tacheRepository tacheRepository;

    @Override
    public Tache ajouterTache(Tache t) {
        return this.tacheRepository.save(t);
    }

    @Override
    public void supprimerTache(Long id) {
        this.tacheRepository.deleteById(id);
    }

    @Override
    public Tache getById(Long id) {
        Optional<Tache> tache= this.tacheRepository.findById(id);
        return tache.isPresent()?tache.get():null;
    }

    @Override
    public List<Tache> listeTaches() {
        return this.tacheRepository.findAll();
    }

    @Override
    public void modifierTache(Long id, Tache t) {
        Tache tacheDb = tacheRepository.findById(id).get();
        System.out.println(tacheDb.toString());
        tacheDb.setNom(t.getNom());
        tacheDb.setStatut(t.getStatut());

        tacheRepository.save(tacheDb);
    }
}
