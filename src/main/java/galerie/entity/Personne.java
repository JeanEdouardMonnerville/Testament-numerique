
package galerie.entity;

import javax.persistence.*;
import lombok.*;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Jean-Edouard
 */
@Getter @Setter @ToString @NoArgsConstructor 
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Personne {

    public Personne(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
        this.achats=new LinkedList<>();
    }
    
    
    
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    @Column(unique=true)
    @NonNull
    private String nom;
    
    @Column
    private String adresse;
    
    @OneToMany( mappedBy="client",cascade=CascadeType.ALL)
    private List<Transaction> achats;
    
         
    public float budgetArt(int annee){
        float result=0f;
        
        for(Transaction t: achats){
            int anneTransac =t.getVenduLe().getYear();
            
            if( anneTransac == annee ){
                result= result+ t.getPrixVente();
                
            }
        }
        return result;
    }
    
    
}
