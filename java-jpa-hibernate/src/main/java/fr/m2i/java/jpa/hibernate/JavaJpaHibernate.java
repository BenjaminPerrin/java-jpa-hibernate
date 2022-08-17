/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package fr.m2i.java.jpa.hibernate;

import fr.m2i.java.jpa.hibernate.helper.SessionHelper;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ben
 */
public class JavaJpaHibernate {

    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("site_commerce_pu");
//        EntityManager entityManager = emf.createEntityManager();
        EntityManager entityManager = SessionHelper.getEntityManager();
        System.out.println("good");
        entityManager.close();
    }
}
