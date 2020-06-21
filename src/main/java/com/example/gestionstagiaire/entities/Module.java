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
public class Module  implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idModule;
    private String codeModule;
    private String intitule;
    private Long masseHoraire;
    @ManyToOne
    @JoinColumn(name = "code")
    private Filiere filiere;
    private String niveau;
}
