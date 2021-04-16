package projetut.dao;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import projetut.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    
     /**
     * Désigne un Ange pour un client
     * @param client_id la clé primaire du client
     * @param angel_id la clé primaire d'un autre client désigné comme ange
     */
    @Transactional
    @Modifying   
    @Query("UPDATE Client SET my_angel_id=:angel_id WHERE id = :client_id")
    void designeLange(Integer client_id,Integer angel_id);
    
    
     /**
     * Supprime un client de la base. Utile quand le client va être déclaré pour mort
     * Cette commande va être excécutée après excécution des actions.
     * @param client_id la clé primaire du client
     */
    @Transactional
    @Modifying
    @Query("Delete * from client where id=:client_id ")
    void supprimerUnClient(Integer client_id);
}