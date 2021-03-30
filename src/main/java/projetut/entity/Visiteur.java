
package projetut.entity;

import javax.persistence.Entity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.ManyToMany;

@Getter @Setter  @ToString
@Entity 
public class Visiteur extends Personne {
    public Visiteur(String nom, String prenom, String mail, String tel) {
        super(nom, prenom, mail, tel);
        
    }
    
    @ManyToMany
    private List<Client> clients;

    
    
    
}
