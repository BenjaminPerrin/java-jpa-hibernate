/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.java.jpa.hibernate.dao;

import fr.m2i.java.jpa.hibernate.helper.SessionHelper;
import fr.m2i.java.jpa.hibernate.model.Utilisateur;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author ben
 */
public class UtilisateurDAO {
    private static EntityManager entityManager;
    
    public UtilisateurDAO() {
        this.entityManager = SessionHelper.getEntityManager();
    }
    
    
    public static void create(Utilisateur user){
            if (user == null) {
                System.out.println("l'object user ne peut pas etre null");
                return;
            }
            EntityTransaction trans = null;
            System.out.println("User :"+user.toString());
            try {
                trans = entityManager.getTransaction();
                trans.begin();
                //Utilisateur newUser = entityManager.merge(user);
                //newUser.setId_role(user.);
                entityManager.persist(user);
                System.out.println("User créé : "+user.toString());
                trans.commit();
            } catch(Exception e) {
                System.out.println("une erreur s'est produite durant la creation de l'user");
                if (trans != null) trans.rollback();
            }
    }
    
    public List<Utilisateur> findAll(){
        Query query = entityManager.createQuery("SELECT u FROM Utilisateur u");
        List<Utilisateur> results = query.getResultList();
        return results;
    }
    
        public static Utilisateur findById(long id){
               Utilisateur founded = entityManager.find(Utilisateur.class, id);
               if (founded == null ) {
               System.out.println("User avec id: "+id +" n'existe pas");
            }
                return founded;
        }
        
        public void update(Long id, Utilisateur roleData) {

        Utilisateur userToUpdate = entityManager.find(Utilisateur.class, id);

        if (userToUpdate == null) {
            System.out.println("Attention le user avec l'id : " + id + " n'exsiste pas !");
            return;
        }

        userToUpdate.copy(roleData);

        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.merge(userToUpdate);

            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur s'est produite lors de la modification de l'user");
            if (tx != null) {
                tx.rollback();
            }
        }
    }
}
