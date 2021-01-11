
package galerie.entity;
import javax.persistence.*;
import lombok.*;

/**
 *
 * 
 */
@Getter @Setter @ToString @NoArgsConstructor @RequiredArgsConstructor
@Entity
public class Tableau {
     @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    @NonNull
    @Column(unique= true)
    private String titre;
    
    @NonNull
    @Column (unique =false)
    private String support;
    
    @NonNull
    @Column (unique=false)
    private int largeur;
    
    @NonNull
    @Column (unique=false)
    private int hauteur;
    
    @ManyToMany
    private Exposition accrochage;
    
    @OneToOne (optional=true)
    private Transaction vendu;
    
    @ManyToOne (optional=true)
    private Artiste auteur;
    
    
    
}
