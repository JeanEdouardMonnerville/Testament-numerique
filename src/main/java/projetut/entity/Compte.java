
package projetut.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.lang.Nullable;

@RequiredArgsConstructor
@Getter @Setter @ToString 
@Entity
public class Compte{

  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name="token")
    private String token;
    
    @Column(name="Adresse_mail")
    private String adresseMail;
    
    //@OneToOne@Nullable
    //private Personne mainProprietaire;
    
    @ManyToOne@Nullable
    private Client proprietaire;          
    
    @OneToMany@Nullable
    private List<ActionGenerique> actionGeneriques; 
    
    @OneToMany@Nullable
    private List<ActionGenerale> actionGenerales;
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compte)) {
            return false;
        }
        Compte other = (Compte) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

  
    
}
