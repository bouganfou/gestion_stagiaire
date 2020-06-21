package com.example.gestionstagiaire.dao;


import com.example.gestionstagiaire.entities.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GroupeRepository extends JpaRepository<Groupe, Long> {
    public Groupe findByCodeGrp(Long code);
	/*@Query("select g from Groupe g where g.intitule like :mc")
	public Page<Groupe> chercher(@Param("mc") String mc, Pageable pageable);*/
}
