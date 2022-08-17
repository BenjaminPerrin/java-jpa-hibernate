/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.java.jpa.hibernate.dao;

import Role.role;
import fr.m2i.java.jpa.hibernate.helper.SessionHelper;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author ben
 */
public class RoleDAO {
    private static EntityManager entityManager;
    
    public RoleDAO() {
        this.entityManager = SessionHelper.getEntityManager();
    }
    
    public static role findById(long id){
            role founded = entityManager.find(role.class, id);
            if (founded == null ) {
            System.out.println("role avec id: "+id +" n'existe pas");
        }
            return founded;
    }
    
    public static void create(role role){
            if (role == null) {
                System.out.println("l'object role ne peut pas etre null");
                return;
            }
            EntityTransaction trans = null;

            try {
                trans = entityManager.getTransaction();
                trans.begin();
                entityManager.persist(role);
                trans.commit();
            } catch(Exception e) {
                System.out.println("une erreur s'est produite durant la creation du role");
                if (trans != null) trans.rollback();
            }
    }
    
//    public static void update(role role){
//            EntityTransaction trans = null;
//
//            try {
//                trans = entityManager.getTransaction();
//                trans.begin();
//                role role1 = entityManager.find(role.class, role.getId_role());
//                role.setId_role(1);
//                entityManager.merge(role);
//                System.out.println("update ok ! "+role1);
//                trans.commit();
//            } catch(Exception e) {
//                if (trans != null) trans.rollback();
//            }
//    }
     // Différente manière : Lister les paramètres modifiables
    // public void update(Long id, String identifiant, String description)
    // On utilise l'id pour le recupérer la donnée
    // => set les données :
    // roleToUpdate.setIdentifiant(identifiant);
    // ...

    // Différente manière : Avoir l'id + les données à modifier encapsulé dans l'entity
    // public void update(Long id, Role roleData)
    // On utilise l'id pour le recupérer la donnée
    // => set les données :
    // roleToUpdate.copy(roleData); -> set uniquement les données qui ne sont pas null

    // Différente manière : Tout encapsuler dans l'entity
    // public void update(Role roleData)
    // On utilise roleData.getId() pour le recupérer la donnée
    // => set les données :
    // roleToUpdate.copy(roleData); -> set uniquement les données qui ne sont pas null

    public void update(Long id, role roleData) {

        role roleToUpdate = entityManager.find(role.class, id);

        if (roleToUpdate == null) {
            System.out.println("Attention le role avec l'id : " + id + " n'exsiste pas !");
            return;
        }

        roleToUpdate.copy(roleData);

        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.merge(roleToUpdate);

            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur s'est produite lors de la modification du role");
            if (tx != null) {
                tx.rollback();
            }
        }
    }
    public List<role> findAll(){
        Query query = entityManager.createQuery("SELECT r FROM role r");
        List<role> results = query.getResultList();
        return results;
    }
}
