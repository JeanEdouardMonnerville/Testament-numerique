
package projetut.entity;
/*
Cette entité regroupera toutes les informations des individus intervenant dans l'application
soit le client, les personnes autorisées à voir la page commémorative du client, la personne désignée 
par le client.
*/
import java.util.List;
import javax.persistence.*;
import lombok.*;
import org.springframework.lang.Nullable;

@Getter @Setter @ToString @NoArgsConstructor
@Entity 
public class Personne {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    @OneToMany(mappedBy="proprietaire") @Nullable
    private List<Compte> comptes;
    
    @OneToMany(mappedBy="myAngel")
    private List<Client> clients;
   
}
