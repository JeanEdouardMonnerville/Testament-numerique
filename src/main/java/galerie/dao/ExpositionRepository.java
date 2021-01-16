
package galerie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import galerie.entity.Exposition;

public interface ExpositionRepository extends JpaRepository<Exposition, Integer> {
    /*
    *Calculer le chiffre d'affaires pour une exposition
    *@param l'id de l'exposition dont on veut le CA
    *@return le CA de l'exposition
    */
    @Query("select sum(v.prixVente) from Exposition e inner join e.ventes v where e.id=?1")
    float chiffreAffairePour(int id);
    //Exposition est un objet qu'on utilise
    //?1 correspond au premier argument de la fonction
    }
