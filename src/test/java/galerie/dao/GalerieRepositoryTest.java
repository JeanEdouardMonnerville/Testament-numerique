package galerie.dao;

import galerie.entity.Galerie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.jdbc.Sql;
import galerie.dao.GalerieRepository;

@Log4j2 // Génère le 'logger' pour afficher les messages de trace
@DataJpaTest
public class GalerieRepositoryTest {
    //On Injecte une ressource par type, fait l'initialisation de galerieDAO
    @Autowired
    private GalerieRepository galerieDAO;

    @Test
    @Sql("test-data.sql") // On peut charger des donnnées spécifiques pour un test
    public void onSaitCompterLesEnregistrements() {
        log.info("On compte les enregistrements de la table 'Galerie'");
        int combienDansLeJeuDeTest = 1; 
        long nombre = galerieDAO.count();
        assertEquals(combienDansLeJeuDeTest, nombre, "On doit trouver 1 galerie" );
    }
    
    @Test
    @Sql("test-data.sql")
    public void testCAParAnnee(){
        //On récupère le premier enregistrement du jeu de test
        Galerie myGalerie=galerieDAO.getOne(1);
        //cet galerie a effectué 40 euros de CA en 2010
        
        assertEquals(40f,myGalerie.CAannuel(2010),"Le calcul du CA en 2010 de cette galerie est mal effectué");
        
        
    }

}
