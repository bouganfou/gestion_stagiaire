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
public class EtablissementFiliere implements Serializable {
    @Id
    private Long idEF;
    @ManyToOne
    @JoinColumn(name = "codeEtablissement")
    private Etablissement etablissement;
    @ManyToOne @JoinColumn(name = "code")
    private Filiere filiere;
}
