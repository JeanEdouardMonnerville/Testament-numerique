
package projetut.entity;

import javax.persistence.Entity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.NoArgsConstructor;

@Getter @Setter  @ToString @NoArgsConstructor
@Entity 
public class Visiteur {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    private String mail;
    private String tel;

    public Visiteur(String mail, String tel) {
        this.mail = mail;
        this.tel = tel;
        }
       
   
    
    @ManyToMany
    private List<Client> clients;

    
    
    
}
