
package projetut.entity;
/*
Cette entité regroupera toutes les informations des individus intervenant dans l'application
soit le client, les personnes autorisées à voir la page commémorative du client, la personne désignée 
par le client.
*/
import javax.persistence.*;
import lombok.*;

@Getter @Setter @ToString @NoArgsConstructor
@Entity 
public class Personne {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    private String nom;
    
    private String prenom;
    
    private String mail;
    
    private String tel;

    public Personne(String nom, String prenom, String mail, String tel) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.tel = tel;
    }
    
    
    
}
