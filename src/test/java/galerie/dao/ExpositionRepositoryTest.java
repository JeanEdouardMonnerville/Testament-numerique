
package galerie.dao;

import galerie.entity.Exposition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.jdbc.Sql;
import galerie.dao.*;
import galerie.entity.Personne;





@Log4j2 // Génère le 'logger' pour afficher les messages de trace
@DataJpaTest
public class ExpositionRepositoryTest {
    @Autowired
    private ExpositionRepository expositionDAO;
    
    @Test
    @Sql("test-data.sql") // On peut charger des donnnées spécifiques pour un test
    public void onSaitCompterLesEnregistrements() {
        log.info("On compte les enregistrements de la table 'Exposition'");
        int combienDansLeJeuDeTest = 1; 
        long nombre = expositionDAO.count();
        assertEquals(combienDansLeJeuDeTest, nombre, "On doit trouver 1 exposition" );
    }
    
    
  
    
    @Sql("test-data.sql")
    @Test
    public void testCA(){
       Exposition myExpo;
    //On récupère l'exposition dans le jeu de test d'ID 1
  
    myExpo=expositionDAO.getOne(1);
    //On vérifie que le chiffre d'affaire calculé est correct
    //Deux tableau on été vendu dans cet exposition
    assertEquals(myExpo.CA(),40f,"Le chiffre d'affaire est incorrect");}
    
    @Sql("test-data.sql")
    @Test
    public void testCAbyId(){
        float CAExpo1=expositionDAO.chiffreAffairePour(1);
        assertEquals(40f,CAExpo1,"Le chiffre d'affaire du premier enregistrement est de 40");
    }
  

    
}
