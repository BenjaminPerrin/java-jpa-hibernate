/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package fr.m2i.java.jpa.hibernate;

import Role.role;
import fr.m2i.java.jpa.hibernate.dao.AdresseDAO;
import fr.m2i.java.jpa.hibernate.dao.RoleDAO;
import fr.m2i.java.jpa.hibernate.dao.UtilisateurDAO;
import fr.m2i.java.jpa.hibernate.helper.SessionHelper;
import fr.m2i.java.jpa.hibernate.model.Adresse;
import fr.m2i.java.jpa.hibernate.model.Utilisateur;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
        AdresseDAO adresseDAO = new AdresseDAO();


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
/*********** USER **********/
//        
//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//        UtilisateurDAO userDao = new UtilisateurDAO();
//
//        // create
//        role role = new role();
//        role.setId_role(1L);
//
//        Utilisateur user = new Utilisateur(role, "Madame", "Mme x", "x", "x_x", "password", true, false, new Date(), new Date(), new Date());
//        Utilisateur user2 = new Utilisateur(role, "Monsieur", "Mr x", "x", "x_x", "password", true, false, new Date(), new Date(), new Date());
//
//        userDao.create(user);
//        userDao.create(user2);
//        
//        // find all
//        List<Utilisateur> users = userDao.findAll();
//
//        for (Utilisateur u : users) {
//            System.out.println("Find all : " + u);
//        }
//
//        // update
//        Utilisateur userData = new Utilisateur();
//        userData.setActif(false);
//        userData.setMarquerEffacer(true);
//
//        try {
//            userData.setDateModification(formatter.parse("11/01/2022"));
//        } catch (ParseException e) {
//            System.out.println("Problème de parsing : " + e.getMessage());
//        }
//
//        userDao.update(2L, userData);
//
//        // find
//        Utilisateur founded = userDao.findById(2L);
//        System.out.println("User updated : " + founded);
        /*********** Adresse **********/

        
         // create
        role role = new role();
        role.setId_role(1L);
        
        Utilisateur user3 = new Utilisateur();
        List<Adresse> list1 = new ArrayList<Adresse>(1);
        user3.setAdressList(list1);

        Utilisateur user = new Utilisateur(role,list1, "Madame", "Mme x", "x", "x_x", "password", true, false, new Date(), new Date(), new Date());
        Utilisateur user2 = new Utilisateur(role,list1, "Monsieur", "Mr x", "x", "x_x", "password", true, false, new Date(), new Date(), new Date());
        
        Adresse adresse1 = new Adresse(user,"france", true, "la rue", "la ville");
        adresseDAO.create(adresse1);
        entityManager.close();

    }
}
