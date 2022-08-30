package com.example.gestion_projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.gestion_projet.models.Phase;


public interface phaseRepository  extends JpaRepository<Phase, Long> {
}
