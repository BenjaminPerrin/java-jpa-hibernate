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
    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("site_commerce_pu");
//        EntityManager entityManager = emf.createEntityManager();
        getEntityManager();
        
    }
    public static EntityManager getEntityManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("site_commerce_pu");
        if (emf == null) {
        EntityManager entityManager = emf.createEntityManager();
        System.out.println("entity ok! "+ entityManager);
        return entityManager;
        }
        System.out.println("nop!");
        return null;
    }
}
