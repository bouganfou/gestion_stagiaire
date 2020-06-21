package com.example.gestionstagiaire.entities;

import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Seance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long numSeance;
    private Date dateRealisation;
    private String heureDebut;
    private String HeureFin;
    @ManyToOne @JoinColumn(name = "idModule")
    private Module module;
    @ManyToOne
    @JoinColumn(name = "codeGrp")
    private Groupe groupe;
    private String absence;
}
