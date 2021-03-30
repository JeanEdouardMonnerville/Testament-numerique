
package projetut.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import projetut.entity.Angel;

public interface AngelRepository extends JpaRepository<Angel, Integer>{
    /*
    @Query("Select * From Client were Client.id:=Clientid ")
    void isDead(Integer Clientid);*/
}
