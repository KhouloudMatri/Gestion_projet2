package com.example.gestion_projet.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Tache implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tache")
    private Long id;
    @Column
    private String nom;
    @Column
    private String statut;

    public Tache() {
    }

    public Tache(Long id, String nom, String statut) {
        this.id = id;
        this.nom = nom;
        this.statut = statut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "Tache{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", statut='" + statut + '\'' +
                '}';
    }
}
