package com.example.gestion_projet.controllers;

import java.util.List;

import com.example.gestion_projet.models.Projet;
import com.example.gestion_projet.services.projetService;
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
@RequestMapping("api/projets")
public class projetController {

    @Autowired
    private projetService projetService;

    @PostMapping
    public Projet ajouterProjet(@RequestBody Projet p) {
        return this.projetService.ajouterProjet(p);
    }

    @GetMapping("")
    public List<Projet> listeProjets() {
        return this.projetService.listeProjets();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Projet> modifierProjet(@PathVariable("id") Long id, @RequestBody Projet p) {
        projetService.modifierProjet(id, p);
        return new ResponseEntity<>(projetService.getById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void supprimerProjet(@PathVariable Long id) {
        this.projetService.supprimerProjet(id);

    }

    @GetMapping("/{id}")
    public Projet getById(@PathVariable Long id) {
        return this.projetService.getById(id);
    }



}
