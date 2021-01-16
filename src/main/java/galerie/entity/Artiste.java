
package galerie.entity;
import javax.persistence.*;
import lombok.*;
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author Jean-Edouard
 */
@Getter @Setter @ToString @RequiredArgsConstructor 
@Entity


public class Artiste extends Personne{
    public Artiste(String nom,String adresse,String biographie){
        
                super(nom,adresse);
                this.biographie=biographie;
                this.oeuvres=new LinkedList<>();
            }
    
    
    @Column
    private String biographie;
    
    @OneToMany(mappedBy="auteur")
    private List<Tableau> oeuvres;
    
}
