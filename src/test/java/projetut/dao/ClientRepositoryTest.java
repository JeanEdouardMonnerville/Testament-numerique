
package projetut.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;



import org.springframework.test.context.jdbc.Sql;



@Log4j2 // Génère le 'logger' pour afficher les messages de trace
@SpringBootConfiguration
@EnableAutoConfiguration
public class ClientRepositoryTest {
    
    @Autowired 
    private ClientRepository clientDao;
    
    @Test
    @Sql("test-data.sql") // On peut charger des donnnées spécifiques pour un test
    public void onSaitCompterLesEnregistrements() {
        log.info("On compte les enregistrements de la table 'client'");
        int combienDansLeJeuDeTest = 1; 
        long nombre = clientDao.count();
        assertEquals(combienDansLeJeuDeTest, nombre, "On doit trouver 1 client" );
    }
}
