
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
import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.NoArgsConstructor;


@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter @Setter  @ToString @NoArgsConstructor
@Entity 
public class Client extends Personne {

   

    public Client(LocalDate dateNaiss, String adresse, String mdp, boolean prive, String nom, String prenom, String mail, String tel) {
        super(nom, prenom, mail, tel);
        this.dateNaiss = dateNaiss;
        this.adresse = adresse;
        this.mdp = mdp;
        this.prive = prive;
        this.dead=false;
    }
    
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
   
    @Column(name="date_naiss")
    private LocalDate dateNaiss;
    
    @Column(name="adresse")
    private String adresse;
    
    @Column(name="mdp")
    private String mdp;
    
    @Column(name="prive")
    private boolean prive;
    
    @Column(name="dead")
    private boolean dead;
    
    @ManyToMany
    @JoinTable(name="Autorisation_Consultation")
    private List<Personne> persAutorisees;
   
    @ManyToOne
    private Angel myAngel;
    
  
}
