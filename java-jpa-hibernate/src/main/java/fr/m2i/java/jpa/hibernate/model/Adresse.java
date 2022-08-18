/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.java.jpa.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
/**
 *
 * @author ben
 */

@Entity
@Table(name = "Adresses")
public class Adresse {
    
    @Id
    @Column(name = "id_adresse")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAdresse;
    
    @JoinColumn(name = "id_utilisateur", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Utilisateur idUtilisateur;
    
    @Column(name = "pays", length = 100)
    private String pays;
    
    @Column(name = "principale", columnDefinition = "TINYINT(1) DEFAULT 1")
    private Boolean principale;
    
    @Column(name = "rue", length = 100)
    private String rue;
    
    @Column(name = "ville", length = 100)
    private String ville;

    public Adresse(Utilisateur idUtilisateur, String pays, Boolean principale, String rue, String ville) {
        this.idUtilisateur = idUtilisateur;
        this.pays = pays;
        this.principale = principale;
        this.rue = rue;
        this.ville = ville;
    }

    public Adresse() {
    }

    public Long getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(Long idAdresse) {
        this.idAdresse = idAdresse;
    }

    public Utilisateur getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Utilisateur idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public Boolean getPrincipale() {
        return principale;
    }

    public void setPrincipale(Boolean principale) {
        this.principale = principale;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "Adresse{" + "idAdresse=" + idAdresse
                + ", idUtilisateur=" + idUtilisateur
                + ", pays=" + pays
                + ", principale=" + principale
                + ", rue=" + rue
                + ", ville=" + ville + '}';
    }
    
    
}
