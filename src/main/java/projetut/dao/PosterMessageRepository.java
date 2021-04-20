package projetut.dao;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import projetut.entity.ActionLinkedIN;
import projetut.entity.PosterMessage;

public interface PosterMessageRepository extends JpaRepository<PosterMessage, Integer>  {
      /**
     * Renvoie une liste d'action pour un compte LinkedIn
     * @param compte_id la clé primaire du compte désigné
     */
    @Query("From ActionLinkedIN WHERE compte_id = :compte_id")
    List<ActionLinkedIN> findAllByCompteId(Integer compte_id);
}
