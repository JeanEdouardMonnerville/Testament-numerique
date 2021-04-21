
package projetut.dao;

import java.util.List;
import lombok.extern.log4j.Log4j2;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import projetut.entity.ActionLinkedIN;

@Log4j2 // Génère le 'logger' pour afficher les messages de trace
@DataJpaTest
public class ActionPostMessageTest {
    
    @Autowired
    private PosterMessageRepository postLinkedIndao;
    
     @Test
    @Sql("test-data.sql")
    public void onSaitCompterLeNombreDActionPostMessage() {
        int combienDansLeJeuDeTest=4;
        long nombre= postLinkedIndao.count();
        assertEquals(combienDansLeJeuDeTest,nombre,"On doit trouver 4 actionS");
    }
    
    @Test
    @Sql("test-data.sql")
    public void findAllByCompteIdTest(){
        List<ActionLinkedIN> actionLinkedIns=postLinkedIndao.findAllByCompteId(4);
        long resultat=1;
        long nombre=actionLinkedIns.size();
        
        assertEquals(resultat,nombre,"On doit trouver 1 action pour le compte 4");
        
        actionLinkedIns=postLinkedIndao.findAllByCompteId(5);
        resultat=3;
        nombre=actionLinkedIns.size();
        assertEquals(resultat,nombre,"On doit trouver 3 action pour le compte 5");
        
        
        
    }
    
}
