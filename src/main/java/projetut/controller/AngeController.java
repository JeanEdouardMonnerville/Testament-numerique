/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import projetut.dao.ClientRepository;

@Controller
public class AngeController {
    
    @Autowired
    private ClientRepository dao;
    
    @RequestMapping(path="PageAnge")
    public String listeDesClientDontJeSuisLange(Model model){
        //TODO: trouver un moyen de récupérer l'id de l'utilisateur actuel
        model.addAttribute("protege", dao.trouveLespersonnesDontJeSuisLange(1));
        return "PageAnge";
    }
    
}
