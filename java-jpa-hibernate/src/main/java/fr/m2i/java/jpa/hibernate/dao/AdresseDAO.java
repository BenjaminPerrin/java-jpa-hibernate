/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.java.jpa.hibernate.dao;

import fr.m2i.java.jpa.hibernate.helper.SessionHelper;
import fr.m2i.java.jpa.hibernate.model.Adresse;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author ben
 */
public class AdresseDAO {
    private static EntityManager entityManager;
    
    public AdresseDAO() {
        this.entityManager = SessionHelper.getEntityManager();
    }
    
    public void create(Adresse adresse) {
        if (adresse == null) {
            System.out.println("L'objet adresse ne peut pas être null");
            return;
        }

        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();
            System.out.println("adresse  "+adresse);
            entityManager.persist(adresse);
            
            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur s'est produite lors de la création de l'adresse");
            System.out.println("Exception message : " + e.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        }
    }
}
