package com.example.gestion_projet.repository;

import com.example.gestion_projet.models.Tache;
import org.springframework.data.jpa.repository.JpaRepository;

public interface tacheRepository extends JpaRepository<Tache, Long> {

}
