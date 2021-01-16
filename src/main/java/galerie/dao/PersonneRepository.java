
package galerie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import galerie.entity.Personne;
import org.springframework.data.jpa.repository.Query;

public interface PersonneRepository extends JpaRepository<Personne, Integer> {
}
