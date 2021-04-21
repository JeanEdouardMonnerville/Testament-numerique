package projetut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import projetut.dao.ClientRepository;

@Controller
public class ClientController {
    
    @Autowired
    ClientRepository clientDao;
    
    @GetMapping(path="/show")
    public String affichageDelaListeDesClientsDansLaPageClient(Model model){
        model.addAttribute("clients", clientDao.findAll());
        return "PageClient";
    }
    
    @PostMapping(path="saveAnge")
    public String choisirUnAnge(int idAnge){
        //TODO: trouver comment récupérer l'id du client de la session actuelle
        clientDao.designeLange(1, idAnge);
        return "redirect:PageClient";
    }
    
    
}
