
package projetut.entity;

import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDate;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Getter @Setter  @ToString
@Entity 
public class Client extends Personne {

    public Client(LocalDate dateNaiss, String adresse, String mdp, boolean prive, String nom, String prenom, String mail, String tel) {
        super(nom, prenom, mail, tel);
        this.dateNaiss = dateNaiss;
        this.adresse = adresse;
        this.mdp = mdp;
        this.prive = prive;
        
    }
    
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
   
    private LocalDate dateNaiss;
    
    private String adresse;
    
    private String mdp;
    
    private boolean prive;
    
    private boolean dead=false;
    
    @ManyToMany(mappedBy="clients")
    private List<Personne> persAutorisees;
   
    @ManyToOne
    private Angel myAngel;
    
    @OneToMany(mappedBy="proprietaire")
    private List<Donnee> patrimoine;
}
