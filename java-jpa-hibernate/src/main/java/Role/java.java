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
public class java implements Serializable {
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

     @Column(
            length = 50
    )
    private String identifiant;
     
    public java(long id_role, String description, String identifiant) {
        this.id_role = id_role;
        this.description = description;
        this.identifiant = identifiant;
    }

    public java() {
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
    
   
    
    
}
