
package galerie.entity;

import javax.persistence.*;
import lombok.*;
import java.time.LocalDate;

/**
 *
 * 
 */
@Getter @Setter @ToString @RequiredArgsConstructor 
@Entity
public class Transaction {
    
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
     
    private LocalDate venduLe;
    
    private float prixVente;
    
    @ManyToOne
    private Exposition lieuDeVente;
    
    @OneToOne
    private Tableau oeuvre;
    
    @ManyToOne
    private Personne client;
    
    
    
}
