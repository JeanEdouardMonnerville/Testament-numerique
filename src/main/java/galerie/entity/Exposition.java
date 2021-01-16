
package galerie.entity;
import javax.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
/**
 *On crée la classe identité Exposition
 * 
 */
@Getter @Setter @ToString @NoArgsConstructor @RequiredArgsConstructor
@Entity
public class Exposition {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(unique = false)
    @NonNull
    private LocalDate dateExpo;
    
    @Column(unique = true)
    @NonNull
    private String intitule;
    
    @Column(unique = false)
    @NonNull
    private int duree;
    
    @ManyToOne
    private Galerie organisateur;
    
    @ToString.Exclude
    @ManyToMany( mappedBy="accrochages" )
    private List<Tableau> oeuvres = new LinkedList<>();
    
    @ToString.Exclude
    @OneToMany(mappedBy="lieuDeVente")
    private List<Transaction> ventes=new LinkedList<>();
    
        public float CA(){
        float result=0f;
        for(Transaction t:ventes){
            result= result+ t.getPrixVente();
        
        }
        
        return result;
        }
    
        
    
}
   
