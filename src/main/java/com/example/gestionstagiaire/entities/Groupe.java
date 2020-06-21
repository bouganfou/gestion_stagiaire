package com.example.gestionstagiaire.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Groupe implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codeGrp;
    private String intitule;
    private String niveau;
    @ManyToOne()
    @JoinColumn(name = "idEF")
    private EtablissementFiliere etablissementFiliere;
}
