/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.java.jpa.hibernate.helper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ben
 */
public class SessionHelper {
    private static EntityManager entityManager;

    public static EntityManager getEntityManager(){
        if (entityManager == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("site_commerce_pu");
            entityManager = emf.createEntityManager();
            System.out.println("entity ok! "+ entityManager);
        }
            System.out.println("nop!");
            return entityManager;
    }
}
