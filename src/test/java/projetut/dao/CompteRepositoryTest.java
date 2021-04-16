/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetut.dao;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@Log4j2 // Génère le 'logger' pour afficher les messages de trace
@DataJpaTest
public class CompteRepositoryTest {
    
    @Autowired
    private CompteRepository compteDAO;
    
    @Test
    @Sql("test-data.sql")
    public void onSaitCompterLeNombreDeCompte() {
        int combirenDansLeJeuDeTest=4;
        long nombre= compteDAO.count();
        assertEquals(combirenDansLeJeuDeTest,nombre,"On doit trouver 3 client");
    }
    
    
}
