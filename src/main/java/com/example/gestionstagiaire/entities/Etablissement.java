package com.example.gestionstagiaire.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor @ToString
public class Etablissement implements Serializable {
    @Id
    private String codeEtablissement;
    private String nomEtab;
}
