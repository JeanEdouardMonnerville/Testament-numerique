
package projetut.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.RequiredArgsConstructor;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@RequiredArgsConstructor
@Getter @Setter @ToString 
@Entity
public class CompteLinkedIN extends Compte{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

   @Column(name="id_Linkedin", unique=true)
    private String idLinkedIn;
    
   @OneToMany(mappedBy="compte")
   private List<ActionLinkedIN> actionLinkedINs;

   
   
   
   
   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompteLinkedIN)) {
            return false;
        }
        CompteLinkedIN other = (CompteLinkedIN) object;
            return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "projetut.entity.CompteLinkedIN[ id=" + id + " ]";
    }
    
}
