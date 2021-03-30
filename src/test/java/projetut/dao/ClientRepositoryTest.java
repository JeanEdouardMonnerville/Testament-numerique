
package projetut.dao;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import projetut.entity.Personne;


import org.springframework.test.context.jdbc.Sql;



@Log4j2 // Génère le 'logger' pour afficher les messages de trace
@DataJpaTest
public class ClientRepositoryTest {
    
    @Autowired 
    private PersonneRepository clientDao;
    
    @Test
    @Sql("test-data.sql") // On peut charger des donnnées spécifiques pour un test
    public void onSaitCompterLesEnregistrements() {
        log.info("On compte les enregistrements de la table 'Galerie'");
        int combienDansLeJeuDeTest = 2; // 1 dans test-data.sql
        long nombre = clientDao.count();
        assertEquals(combienDansLeJeuDeTest, nombre, "On doit trouver 1 client" );
    }
    }

