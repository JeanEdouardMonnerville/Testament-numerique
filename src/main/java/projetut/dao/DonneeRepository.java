
package projetut.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import projetut.entity.Donnee;
import java.util.List;
public interface DonneeRepository extends JpaRepository<Donnee, Integer>{
    /*
    @Query("SELECT * FROM Donnee WHERE Donnee.proprietaire_id = :Clientid")
    List<Donnee> getDataOf(Integer Clientid);*/
}
