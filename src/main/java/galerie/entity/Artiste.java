
package galerie.entity;
import javax.persistence.*;
import lombok.*;
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author Jean-Edouard
 */
@Getter @Setter @ToString 
@Entity
public class Artiste extends Personne{
   
    @Column
    private String biographie;
    
    @OneToMany(mappedBy="Artiste")
    private List<Tableau> oeuvres=new LinkedList<>();
    
}
