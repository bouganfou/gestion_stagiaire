package com.example.gestionstagiaire.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Personnel implements Serializable {
    @Id
    private String matricule;
    private String nom;
    private String prenom;
    private String motPass;
    private String fonction;
    @ManyToOne
    @JoinColumn(name="codeEtablissement")
    private Etablissement etablissement;

}
