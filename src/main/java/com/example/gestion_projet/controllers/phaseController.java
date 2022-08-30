package com.example.gestion_projet.controllers;

import java.util.List;

import com.example.gestion_projet.models.Phase;
import com.example.gestion_projet.services.phaseService;
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
@RequestMapping("api/phases")
public class phaseController {
    @Autowired
    phaseService phaseService;

    @PostMapping
    public Phase ajouterPhase(@RequestBody Phase ph) {return this.phaseService.ajouterPhase(ph); }

    @GetMapping("")
    public List<Phase> listePhases() {
        return this.phaseService.listePhases();
    }


    @PutMapping("/{id}")
    public ResponseEntity<Phase> modifierPhase(@PathVariable("id") Long id, @RequestBody Phase ph) {
        phaseService.modifierPhase(id, ph);
        return new ResponseEntity<>(phaseService.getById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void supprimerPhases(@PathVariable Long id) {
        this.phaseService.supprimerPhase(id);

    }

    @GetMapping("/{id}")
    public Phase getById(@PathVariable Long id) {
        return this.phaseService.getById(id);
    }

}
