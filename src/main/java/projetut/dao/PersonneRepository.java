
package projetut.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import projetut.entity.Personne;

public interface PersonneRepository extends JpaRepository<Personne, Integer> {
    
}