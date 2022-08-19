/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.java.jpa.hibernate.dao;

import fr.m2i.java.jpa.hibernate.helper.SessionHelper;
import fr.m2i.java.jpa.hibernate.model.Produit;
import javax.persistence.*;
import java.util.List;
/**
 *
 * @author ben
 */
public class ProduitDAO {
    private final EntityManager entityManager;

    public ProduitDAO() {
        this.entityManager = SessionHelper.getEntityManager();
    }
    
    public List<Produit> findAll() {
        Query findAllQuery = entityManager.createQuery("select u from Produit u");
        return findAllQuery.getResultList();
    }
    
    public Produit findById(Long id) {
        Produit founded = entityManager.find(Produit.class, id);

        if (founded == null) {
            System.out.println("Attention le produit avec l'id : " + id + " n'exsiste pas !");
        }

        return founded;
    }
    
    public void create(Produit produit) {

        if (produit == null) {
            System.out.println("L'objet produit ne peut pas être null");
            return;
        }

        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();
            
            entityManager.persist(produit);
            
            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur s'est produite lors de la création du produit");
            System.out.println("Exception message : " + e.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        }
    }
    
    public void update(Long id, Produit produitData) {

        Produit adresseToUpdate = entityManager.find(Produit.class, id);

        if (adresseToUpdate == null) {
            System.out.println("Le adresse avec l'id:" + id + " n'existe pas");
            return;
        }

        adresseToUpdate.copy(produitData);

        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.merge(adresseToUpdate);

            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur est survenu lors de la modification");
            System.out.println("Exception message : " + e.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        }
    }
    
    public List<Produit> findByName(String name){
        Query query = entityManager.createQuery("SELECT r FROM produit r where r.name="+name+"");
        List<Produit> results = query.getResultList();
        return results;
    }
    
    public List<Produit> findByDescription(String description){
        Query query = entityManager.createQuery("SELECT r FROM produit r where r.description="+description+"");
        List<Produit> results = query.getResultList();
        return results;
    }
    
    public List<Produit> findByPrix(float prix){
        Query query = entityManager.createQuery("SELECT r FROM produit r where r.prix="+prix+"");
        List<Produit> results = query.getResultList();
        return results;
    }
    
    public List<Produit> findByReference(String reference){
        Query query = entityManager.createQuery("SELECT r FROM produit r where r.reference="+reference+"");
        List<Produit> results = query.getResultList();
        return results;
    }
}
