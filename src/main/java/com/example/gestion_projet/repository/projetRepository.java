package com.example.gestion_projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.gestion_projet.models.Projet;

public interface projetRepository extends JpaRepository<Projet, Long> {
}
