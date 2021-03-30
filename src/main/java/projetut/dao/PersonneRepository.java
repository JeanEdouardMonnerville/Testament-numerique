
package projetut.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import projetut.entity.Personne;
import org.springframework.data.jpa.repository.Query;

public interface PersonneRepository extends JpaRepository<Personne, Integer> {
}
