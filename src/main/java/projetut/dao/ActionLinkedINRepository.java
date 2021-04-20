
package projetut.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import projetut.entity.ActionLinkedIN;

public interface ActionLinkedINRepository extends JpaRepository<ActionLinkedIN, Integer>  {
    
     /**
     * Renvoie une liste d'action pour un compte LinkedIn
     * @param compte_id la clé primaire du compte désigné
     *//*
    @Transactional
    @Modifying   
    @Query("SELECT * From action_linkedin WHERE compte_id = :compte_id")
    List<ActionLinkedIN> ToutesLesActionsLinkedInPourUnCompte(Integer compte_id);*/
}
