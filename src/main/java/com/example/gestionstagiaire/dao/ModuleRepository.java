package com.example.gestionstagiaire.dao;

import com.example.gestionstagiaire.entities.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository<Module,Long> {
 public Module findByIdModule(Long id);

}
