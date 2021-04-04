
package projetut.entity;
/*
Cette entité regroupera toutes les informations des individus intervenant dans l'application
soit le client, les personnes autorisées à voir la page commémorative du client, la personne désignée 
par le client.
*/
import javax.persistence.*;
import lombok.*;
import org.springframework.lang.Nullable;

@Getter @Setter @ToString @NoArgsConstructor
@Entity 
public class Personne {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    //@OneToOne@Nullable
    //private Compte comptePrincipal;
}
