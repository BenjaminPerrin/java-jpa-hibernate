/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package fr.m2i.java.jpa.hibernate;

import Role.role;
import fr.m2i.java.jpa.hibernate.dao.RoleDAO;
import fr.m2i.java.jpa.hibernate.helper.SessionHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ben
 */
public class JavaJpaHibernate {

    public static void main(String[] args) {
        EntityManager entityManager = SessionHelper.getEntityManager();
        RoleDAO roleDao = new RoleDAO();

        // create
        //role roleAdmin = new role("ADMIN", "Le rôle Administrateur"); 
        //roleDao.create(roleAdmin);

        // find
       // role founded = roleDao.findById(1L);
        //System.out.println("Role CREATED : " + founded);

        // update
        //role roleData = new role();
       // roleData.setDescription("Le rôle Administrateur implique de grandes responsabilités");

        //roleDao.update(1L, roleData);

        // find
        //role updated = roleDao.findById(1L);
       // System.out.println("Role UPDATED : " + updated);

        //findall
        List<role> results = roleDao.findAll();
        System.out.println("results : " + results);
        
        entityManager.close();

    }
}
