
package projetut.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.RequiredArgsConstructor;
import java.util.List;
import lombok.AccessLevel;
import org.springframework.lang.Nullable;

@RequiredArgsConstructor
@Getter @Setter @ToString 
@Entity
public class Compte{

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name="token", length = 512)
    private String Accesstoken;
    
    @Column(name="Adresse_mail")
    private String adresseMail;
    
    @OneToMany(mappedBy="compte")@Nullable
    private List<ActionGenerique> actionGeneriques; 
    
    @OneToMany(mappedBy="compte")@Nullable
    private List<ActionGenerale> actionGenerales;
    
    @ManyToOne
    private Client proprietaire;
    
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
