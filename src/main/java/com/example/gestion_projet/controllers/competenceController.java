package com.example.gestion_projet.controllers;

import java.util.List;
import java.util.Set;

import com.example.gestion_projet.models.Competence;
import com.example.gestion_projet.repository.competenceRepository;
import com.example.gestion_projet.services.competenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin("*")
@RestController
@RequestMapping("api/competences")
public class competenceController {
    @Autowired
    competenceService competenceService;

    @Autowired
    competenceRepository competenceRepository;

    @PostMapping
    public Competence ajouterCompetence(@RequestBody Competence c) {return this.competenceService.ajouterCompetence(c); }

    @GetMapping("")
    public List<Competence> listeCompetences() {
        return this.competenceService.listeCompetences();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Competence> modifierCompetence(@PathVariable("id") Long id, @RequestBody Competence c) {
        competenceService.modifierCompetence(id, c);
        return new ResponseEntity<>(competenceService.getById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void supprimerCompetences(@PathVariable Long id) {
        this.competenceService.supprimerCompetence(id);

    }

/*    @GetMapping("/{id}")
    public Competence getById(@PathVariable Long id) {
        return this.competenceService.getById(id);
    }*/

    @GetMapping("/{id}")
    public Set<Competence> getByProjectId(@PathVariable Long id){
        return competenceRepository.findCompetenceByProjetsId(id);
    }

}