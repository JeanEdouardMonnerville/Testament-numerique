
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
import org.springframework.lang.Nullable;


@Getter @Setter  @ToString 
@Entity 
public class Client  {

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
   
    @ManyToOne@Nullable
    private Client myAngel;
    
    @OneToMany(mappedBy="myAngel")@Nullable
    private List<Client> clients;
    
    @OneToMany(mappedBy="proprietaire")
    private List<Compte> comptes;
   
}
