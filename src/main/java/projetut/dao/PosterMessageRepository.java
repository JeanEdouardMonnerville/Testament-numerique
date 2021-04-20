package projetut.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import projetut.entity.PosterMessage;

public interface PosterMessageRepository extends JpaRepository<PosterMessage, Integer>  {
    
     /**
     * Renvoie une liste de post pour un compte LinkedIn
     * @param compte_id la clé primaire du compte désigné
     * @return liste de message à poster
     */
    /*@Transactional
    @Modifying   
    @Query("SELECT* From action_linkedin WHERE compte_id = :compte_id")
    List<PosterMessage> ToutesLesActionsLinkedInPourUnCompte(Integer compte_id);*/
}
