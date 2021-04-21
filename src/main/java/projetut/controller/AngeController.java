
package projetut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import projetut.dao.ClientRepository;
/*
Ce controlleur va surtout intervenir dans les fonctionnalités à apporter aux pages clients
*/
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
    
    @PostMapping(path="deadValid")
    public String declarationDeMort(){
        //TODO implémenter la fonctionnalité permettant la déclaration de la mort d'un client
        //clientQuiEstMort.setDead(True);
        return "redirect:/Identification";
    }
    
}
