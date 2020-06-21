package com.example.gestionstagiaire.dao;

import com.example.gestionstagiaire.entities.Module;
import com.example.gestionstagiaire.entities.Seance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeanceRepository extends JpaRepository<Seance,Long> {
 public List<Seance> findByModule(Module module);

}
