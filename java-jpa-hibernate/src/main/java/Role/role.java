/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Role;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author ben
 */
@Entity
@Table(name = "roles")
public class role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
        length = 20,
        columnDefinition="BIGINT"
    )
    private long id_role;
    
    @Column(
        columnDefinition="TEXT"
    )
    private String description;

    @Override
    public String toString() {
        return "java{" + "id_role=" + id_role + ", description=" + description + ", identifiant=" + identifiant + '}';
    }

     @Column(
            length = 50
    )
    private String identifiant;
     
    public role(String description, String identifiant) {
        this.description = description;
        this.identifiant = identifiant;
    }

    public role() {
    }

    public long getId_role() {
        return id_role;
    }

    public void setId_role(long id_role) {
        this.id_role = id_role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }
    
   
    public void copy(role roleData) {

        if (roleData.getIdentifiant() != null) {
            this.setIdentifiant(roleData.getIdentifiant());
        }

        if (roleData.getDescription()!= null) {
            this.setDescription(roleData.getDescription());
        }
    }
    
}
