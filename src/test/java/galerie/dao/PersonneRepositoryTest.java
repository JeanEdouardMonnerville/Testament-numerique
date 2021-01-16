
package galerie.dao;
import galerie.entity.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.jdbc.Sql;
import galerie.dao.*;


@DataJpaTest
@Log4j2
public class PersonneRepositoryTest {
    @Autowired
    private PersonneRepository personneDAO;
    
    @Test
    @Sql("test-data.sql") // On peut charger des donnnées spécifiques pour un test
    public void onSaitCompterLesEnregistrements() {
        log.info("On compte les enregistrements de la table 'Personne et Artiste'");
        int combienDansLeJeuDeTest = 1; 
        long nombre = personneDAO.count();
        assertEquals(combienDansLeJeuDeTest, nombre, "On doit trouver 1 personne" );
    }
    
    @Sql("test-data.sql")
    @Test
    //On test la fonction budjetArt de la classe Personne
    public void testBudjetAnnuel(){
        Personne myPersonne=personneDAO.getOne(1);
        //Ce client a fait 2 transaction de 20f
        int annee=2010;
        assertEquals(40f,myPersonne.budgetArt(annee),"Le budget annuel est mal calculé");
              
        
        
        
    }
    
}
