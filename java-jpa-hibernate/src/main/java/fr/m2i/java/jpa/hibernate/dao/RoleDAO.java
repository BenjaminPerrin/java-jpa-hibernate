/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.java.jpa.hibernate.dao;

import Role.role;
import fr.m2i.java.jpa.hibernate.helper.SessionHelper;
import javax.persistence.*;

/**
 *
 * @author ben
 */
public class RoleDAO {
    private static EntityManager entityManager;
    
    public static role findById(long id){
            entityManager = SessionHelper.getEntityManager();
            System.out.println("findbyid ok ! "+entityManager.find(role.class, id));
            return entityManager.find(role.class, id);
    }
    
    public static void create(role role){
            entityManager = SessionHelper.getEntityManager();
            EntityTransaction trans = null;

            try {
                trans = entityManager.getTransaction();
                trans.begin();
                entityManager.persist(role);
                trans.commit();
            } catch(Exception e) {
                if (trans != null) trans.rollback();
            }
    }
    
    public static void update(role role){
            entityManager = SessionHelper.getEntityManager();
            EntityTransaction trans = null;

            try {
                trans = entityManager.getTransaction();
                trans.begin();
                role role1 = entityManager.find(role.class, role.getId_role());
                entityManager.merge(role);
                trans.commit();
                System.out.println("update ok ! "+role1);
            } catch(Exception e) {
                if (trans != null) trans.rollback();
            }
    }
}
