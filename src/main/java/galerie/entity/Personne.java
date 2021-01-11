
package galerie.entity;

import javax.persistence.*;
import lombok.*;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Jean-Edouard
 */
@Getter @Setter @ToString @NoArgsConstructor @RequiredArgsConstructor
@Entity
public class Personne {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    @Column(unique=true)
    @NonNull
    private String nom;
    
    @Column
    private String adresse;
    
    @OneToMany( cascade=CascadeType.ALL)
    private List<Transaction> achats=new LinkedList<>();
    
}
