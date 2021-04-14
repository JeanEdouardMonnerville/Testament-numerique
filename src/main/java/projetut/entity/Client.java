
package projetut.entity;

import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;
import javax.validation.constraints.NotNull;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter @Setter  @ToString 
@Entity 
public class Client extends Personne {

    public Client() {
        super();
        this.dead=false;
    }
    
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
   
   
    @Column(name="dead")
    private boolean dead;
    
    @NotNull
    private String nom;
    
    @NotNull
    private String prenom;
   
    @ManyToOne
    private Personne myAngel;
    
   
}
