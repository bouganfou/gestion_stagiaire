package com.example.gestionstagiaire.dao;

import com.example.gestionstagiaire.entities.Groupe;
import com.example.gestionstagiaire.entities.ModuleFormateurGroupe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModuleFormateurGroupeRepository extends JpaRepository<ModuleFormateurGroupe,Long> {
    public List<ModuleFormateurGroupe> findByGroupe(Groupe groupe);
}
