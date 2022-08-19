/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.java.jpa.hibernate.model;

import javax.persistence.*;
/**
 *
 * @author ben
 */
@Entity
@Table(name = "produits")
public class Produit {
    
    @Id
    @Column(name = "id_produit")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;
    
    @Column(name = "active", columnDefinition = "TINYINT(1) DEFAULT 1")
    private Boolean active;
    
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    
    @Column(name = "nom", length = 100)
    private String nom;
    
    @Column(name = "prix", columnDefinition = "FLOAT")
    private float prix;
    
    @Column(name = "reference", length = 100)
    private String reference;
    
    @Column(name = "stock", length = 11, columnDefinition = "INT")
    private int stock;

    public Produit(Boolean active, String description, String nom, float prix, String reference, int stock) {
        this.active = active;
        this.description = description;
        this.nom = nom;
        this.prix = prix;
        this.reference = reference;
        this.stock = stock;
    }

    public Produit() {
    }

    public Long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Long idProduit) {
        this.idProduit = idProduit;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Produit{" + "idProduit=" + idProduit
                + ", active=" + active
                + ", description=" + description
                + ", nom=" + nom
                + ", prix=" + prix
                + ", reference=" + reference
                + ", stock=" + stock + '}';
    }
    
    public void copy(Produit produitData) {

        if (produitData == null) {
            return;
        }

        if (produitData.getIdProduit()!= null) {
            this.idProduit = produitData.getIdProduit();
        }

        if (produitData.getDescription()!= null) {
            this.description = produitData.getDescription();
        }

        if (produitData.getNom() != null) {
            this.nom = produitData.getNom();
        }

        if (produitData.getPrix() < 0) {
            this.prix = produitData.getPrix();
        }

        if (produitData.getReference() != null) {
            this.reference = produitData.getReference();
        }
        
        if (produitData.getStock() < 0) {
            this.stock = produitData.getStock();
        }
    }
}
