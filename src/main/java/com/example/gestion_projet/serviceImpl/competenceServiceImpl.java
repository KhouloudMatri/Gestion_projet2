package com.example.gestion_projet.serviceImpl;

import com.example.gestion_projet.models.Competence;
import com.example.gestion_projet.repository.competenceRepository;
import com.example.gestion_projet.services.competenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class competenceServiceImpl implements competenceService {

    @Autowired
    competenceRepository competenceRepository;

    @Override
    public Competence ajouterCompetence(Competence c) {
        return this.competenceRepository.save(c);
    }

    @Override
    public void supprimerCompetence(Long id) {
        this.competenceRepository.deleteById(id);
    }

    @Override
    public Competence getById(Long id) {
        Optional<Competence> competence= this.competenceRepository.findById(id);
        return competence.isPresent()?competence.get():null;
    }

    @Override
    public List<Competence> listeCompetences() {
        return this.competenceRepository.findAll();
    }

    @Override
    public void modifierCompetence(Long id, Competence c) {
        Competence compDb = competenceRepository.findById(id).get();
        System.out.println(compDb.toString());
        compDb.setNom(c.getNom());
        competenceRepository.save(compDb);
    }
}