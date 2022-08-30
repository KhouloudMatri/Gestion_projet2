package com.example.gestion_projet.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Competence implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_competence")
    private Long id;
    @Column
    private String nom;

    //Jointure
    @ManyToMany(mappedBy = "competences")
    private Set<Projet> projets;

   /* @ManyToMany(mappedBy = "competencess")
    private Set<Ressource> ressources;*/


    public Competence() {
    }

    public Competence(Long id, String nom) {
        id = id;
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Competence{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
