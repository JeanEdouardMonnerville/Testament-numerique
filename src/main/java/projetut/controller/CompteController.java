/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import projetut.dao.CompteRepository;
import projetut.entity.Compte;

@Controller
@RequestMapping(path="/addAccount")
public class CompteController {
    
    @Autowired
    private CompteRepository compteDAO;
    
    public String ajouteLeTokenALaBasePuisAfficheLidentification(String Token, String mail){
        /*
        Compte compte=new Compte(Token,mail);
        try {
            compteDAO.save(compte);
        } catch (DataIntegrityViolationException e) {
        }*/
        return "Identification"; 
    
}
}
