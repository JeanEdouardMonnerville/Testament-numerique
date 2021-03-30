
package projetut.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import projetut.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    
}