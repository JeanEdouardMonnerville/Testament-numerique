
package projetut.dao;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import projetut.entity.ActionGenerale;

public interface ActionGeneralRepository extends JpaRepository<ActionGenerale, Integer>  {
     /**
     * Trouve toutes les actions générales en fonction de l'id du compte entré
     * @param vcompte_id la clé primaire du client
     * @return liste des actions générales
     */
    @Query("From ActionGenerale WHERE compte_id = :vcompte_id")
    List<ActionGenerale> findAllByCompteId(Integer vcompte_id);
}
