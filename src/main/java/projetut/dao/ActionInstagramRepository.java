
package projetut.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import projetut.entity.ActionInstagram;
import projetut.entity.ActionLinkedIN;


public interface ActionInstagramRepository extends JpaRepository<ActionInstagram, Integer>{
      /**
     * Renvoie une liste d'action pour un compte Instagram
     * @param vcompte_id la clé primaire du compte désigné
     */
    @Query("From ActionInstagram WHERE compte_id = :vcompte_id")
    List<ActionInstagram> findAllByCompteId(Integer vcompte_id);
    
}
