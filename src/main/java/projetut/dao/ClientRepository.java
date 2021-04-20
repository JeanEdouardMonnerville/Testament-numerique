package projetut.dao;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import projetut.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    
     /**
     * Désigne un Ange pour un client
     * @param client_id la clé primaire du client
     * @param ange_id la clé primaire d'un autre client désigné comme ange
     */
    @Transactional
    @Modifying   
    @Query("UPDATE Client SET my_angel_id=:ange_id WHERE id = :client_id")
    void designeLange(Integer client_id,Integer ange_id);
    
    /**
     * Trouve la liste des individus qui ont désigné un client comme ange
     * @param vclient_id la clé primaire du client
     * @return liste de clié veillé par l'ange
     */
    @Query("From Client Where my_angel_id=:vclient_id ")
    List<Client> trouveLespersonnesDontJeSuisLange(Integer vclient_id);
    
    
   
}