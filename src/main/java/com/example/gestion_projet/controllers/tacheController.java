package com.example.gestion_projet.controllers;

import java.util.List;

import com.example.gestion_projet.models.Tache;
import com.example.gestion_projet.services.tacheService;
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
@RequestMapping("api/taches")
public class tacheController {

    @Autowired
    private tacheService tacheService;

    @PostMapping
    public Tache ajouterTache(@RequestBody Tache t) {
        return this.tacheService.ajouterTache(t);
    }

    @GetMapping("")
    public List<Tache> listeTaches() {
        return this.tacheService.listeTaches();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tache> modifierTache(@PathVariable("id") Long id, @RequestBody Tache t) {
        tacheService.modifierTache(id, t);
        return new ResponseEntity<>(tacheService.getById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void supprimerTache(@PathVariable Long id) {
        this.tacheService.supprimerTache(id);

    }

    @GetMapping("/{id}")
    public Tache getById(@PathVariable Long id) {
        return this.tacheService.getById(id);
    }



}
