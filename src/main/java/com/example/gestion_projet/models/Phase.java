package com.example.gestion_projet.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.example.gestion_projet.models.Projet;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Phase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_phase")
    private Long id;
    @Column
    private String nom_phase;
    @Column
    private String duree;
    @Column
    @JsonFormat(pattern = "yyyy/MM/dd", shape = JsonFormat.Shape.STRING)
    private String date_debut_phase;
    @JsonFormat(pattern = "yyyy/MM/dd", shape = JsonFormat.Shape.STRING)
    @Column
    private String date_fin_phase;
    @Column
    private String etat;

    //Jointure
    @ManyToOne
    @JoinColumn(name="id_projet")
    private Projet projet;

    public Phase() {
    }

    public Phase(Long id, String nom_phase, String duree, String date_debut_phase, String date_fin_phase, String etat) {
        this.id = id;
        this.nom_phase = nom_phase;
        this.duree = duree;
        this.date_debut_phase = date_debut_phase;
        this.date_fin_phase = date_fin_phase;
        this.etat = etat;
    }

    public Phase(Long id, String nom_phase, String duree, String date_debut_phase, String date_fin_phase, String etat, Projet projet) {
        this.id = id;
        this.nom_phase = nom_phase;
        this.duree = duree;
        this.date_debut_phase = date_debut_phase;
        this.date_fin_phase = date_fin_phase;
        this.etat = etat;
        this.projet = projet;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom_phase() {
        return nom_phase;
    }

    public void setNom_phase(String nom_phase) {
        this.nom_phase = nom_phase;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getDate_debut_phase() {
        return date_debut_phase;
    }

    public void setDate_debut_phase(String date_debut_phase) {
        this.date_debut_phase = date_debut_phase;
    }

    public String getDate_fin_phase() {
        return date_fin_phase;
    }

    public void setDate_fin_phase(String date_fin_phase) {
        this.date_fin_phase = date_fin_phase;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Projet getProjet() {
        return this.projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    @Override
    public String toString() {
        return "Phase{" +
                "id=" + id +
                ", nom_phase='" + nom_phase + '\'' +
                ", duree='" + duree + '\'' +
                ", date_debut_phase='" + date_debut_phase + '\'' +
                ", date_fin_phase='" + date_fin_phase + '\'' +
                ", etat='" + etat + '\'' +
                ", projet=" + projet +
                '}';
    }
}
