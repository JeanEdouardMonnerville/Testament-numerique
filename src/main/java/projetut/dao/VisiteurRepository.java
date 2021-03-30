
package projetut.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import projetut.entity.Visiteur;

public interface VisiteurRepository extends JpaRepository <Visiteur, Integer> {
    
}
