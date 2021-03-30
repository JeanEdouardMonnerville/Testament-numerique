
package projetut.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.ManyToOne;


@Getter @Setter  @ToString
@Entity 
public class Donnee {
    
    public Donnee() {
    }
    
     @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
     private Integer id;
     
     private byte[] image;
     
     @ManyToOne
     private Client proprietaire;

     
}
