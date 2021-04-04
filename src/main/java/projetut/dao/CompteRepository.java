
package projetut.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import projetut.entity.Compte;

public interface CompteRepository extends JpaRepository<Compte, Integer>{
    
}
