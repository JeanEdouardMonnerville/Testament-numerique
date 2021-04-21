
package projetut.dao;



import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import org.springframework.test.context.jdbc.Sql;
import projetut.entity.Client;



@Log4j2 // Génère le 'logger' pour afficher les messages de trace
@DataJpaTest
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientDao;
   
    
    @Test
    @Sql("test-data.sql")
    public void onSaitCompterLeNombreDeClient() {
        int combirenDansLeJeuDeTest=5;
        long nombre= clientDao.count();
        assertEquals(combirenDansLeJeuDeTest,nombre,"On doit trouver 5 client");
    }
    
    @Test
    @Sql("test-data.sql")
    public void onPeutSavoirSiUnClientEstMort() {
        Optional<Client> c1=clientDao.findById(1);
        assertEquals(false,c1.get().isDead(),"Ce client est toujours vivant");
    }
    
     @Test
     @Sql("test-data.sql")
     public void unClientPeutDesignerUnAnge(){
         clientDao.designeLange(1, 2);
         Optional<Client> c1=clientDao.findById(1);
         Client myAngel=clientDao.findById(2).get();
         assertEquals(myAngel,c1.get().getMyAngel(),"L'ange a mal été désigné");
     }
     
     @Test
     @Sql("test-data.sql")
     public void trouveLespersonnesDontJeSuisLangeTest(){
         clientDao.designeLange(2, 1);
         clientDao.designeLange(3, 1);
         clientDao.designeLange(4, 1);
         
         List<Client> mesAngelé=clientDao.trouveLespersonnesDontJeSuisLange(1);
         
         assertEquals(3,mesAngelé.size(),"3 client ont choisi le client 1 comme ange");
         
         
     }
    
    
    }

