/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.java.jpa.hibernate.model;

import Role.role;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author ben
 */
@Entity
@Table(name = "utilisateurs")
public class Utilisateur implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
        length = 20,
        columnDefinition="BIGINT"
    )
    private long id_utilisateur;
    
    @Column(
        length = 1,
        columnDefinition="TINYINT"
    )
    private long actif;
    
    @Column(
        length = 100
    )
    private String civilite;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_creation;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_modification;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_naissance;
    
    @Column(
        length = 100
    )
    private String identifiant;
    
    @Column(
        length = 1,
        columnDefinition="TINYINT"
    )
    private long marquer_effacer;
    
    @Column(
        length = 100
    )
    private String mot_pass;
    
    @Column(
        length = 100
    )
    private String nom;
    
    @Column(
        length = 100
    )
    private String prenom;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_role")
    private role id_role;

    public Utilisateur(long actif, String civilite, Date date_creation, Date date_modification, Date date_naissance, String identifiant, long marquer_effacer, String mot_pass, String nom, String prenom, role id_role) {
        this.actif = actif;
        this.civilite = civilite;
        this.date_creation = date_creation;
        this.date_modification = date_modification;
        this.date_naissance = date_naissance;
        this.identifiant = identifiant;
        this.marquer_effacer = marquer_effacer;
        this.mot_pass = mot_pass;
        this.nom = nom;
        this.prenom = prenom;
        this.id_role = id_role;
    }



    public role getId_role() {
        return id_role;
    }

    public void setId_role(role id_role) {
        this.id_role = id_role;
    }


    public Utilisateur() {
    }

    public long getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(long id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public long getActif() {
        return actif;
    }

    public void setActif(long actif) {
        this.actif = actif;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public Date getDate_modification() {
        return date_modification;
    }

    public void setDate_modification(Date date_modification) {
        this.date_modification = date_modification;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }



    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public long getMarquer_effacer() {
        return marquer_effacer;
    }

    public void setMarquer_effacer(long marquer_effacer) {
        this.marquer_effacer = marquer_effacer;
    }

    public String getMot_pass() {
        return mot_pass;
    }

    public void setMot_pass(String mot_pass) {
        this.mot_pass = mot_pass;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

   
    
    
}
