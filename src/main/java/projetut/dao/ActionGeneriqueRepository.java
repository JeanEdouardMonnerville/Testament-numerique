
package projetut.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import projetut.entity.ActionGenerique;
import projetut.entity.ActionInstagram;

public interface ActionGeneriqueRepository extends JpaRepository<ActionGenerique, Integer>  {
        /**
     * Renvoie une liste d'action pour un compte 
     * @param vcompte_id la clé primaire du compte désigné
     */
    @Query("From ActionGenerique WHERE compte_id = :vcompte_id")
    List<ActionGenerique> findAllByCompteId(Integer vcompte_id);
    
   
}
