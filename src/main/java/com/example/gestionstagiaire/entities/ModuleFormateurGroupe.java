package com.example.gestionstagiaire.entities;

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
public class ModuleFormateurGroupe implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne @JoinColumn(name = "codeGrp")
    private Groupe groupe;
    @ManyToOne @JoinColumn(name = "idModule")
    private Module module;
    @ManyToOne @JoinColumn(name = "matricule")
    private Personnel personnel;
    private Date dateEFM;
    private String cumul;
}
