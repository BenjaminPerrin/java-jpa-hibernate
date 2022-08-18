/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package fr.m2i.java.jpa.hibernate;

import Role.role;
import fr.m2i.java.jpa.hibernate.dao.RoleDAO;
import fr.m2i.java.jpa.hibernate.dao.UtilisateurDAO;
import fr.m2i.java.jpa.hibernate.helper.SessionHelper;
import fr.m2i.java.jpa.hibernate.model.Utilisateur;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        UtilisateurDAO userDAO = new UtilisateurDAO();

        // create
        role roleAdmin = new role("ADMIN", "Le rôle Administrateur");
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
//        List<role> results = roleDao.findAll();
//        System.out.println("results : " + results);
        /**
         *
         * User part
         */
        //create
//        String dateFormat = "MM-dd-yyyy";
//        try {
//            DateFormat df = new SimpleDateFormat(dateFormat);
//            Date dateToUse = df.parse("02-01-2005");
//            roleAdmin.setId_role(1);
//            Utilisateur newUser = new Utilisateur(roleAdmin,"monsieur","perrin","benjamin","identifiant cc","monMDP",true,false,dateToUse,dateToUse,dateToUse); 
//            userDAO.create(newUser);
//        } catch (ParseException pe) {
//             System.out.println("fail ");
//        }
        //findall
//            List<Utilisateur> results = userDAO.findAll();
//            System.out.println("results : " + results);
        // findbyID
        //Utilisateur founded = userDAO.findById(1L);
        //System.out.println("user found : " + founded);
        
         //update
//        Utilisateur userData = new Utilisateur();
//         userData.setMotPasse("Le nouvceau mdp");
//        userDAO.update(1L, userData);
        entityManager.close();

    }
}
