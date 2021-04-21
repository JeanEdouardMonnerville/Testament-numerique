
package projetut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import projetut.dao.CompteRepository;
import projetut.dao.PosterMessageRepository;
import projetut.entity.PosterMessage;
import projetut.entity.Compte;

/*
Controleur de gestion de l'action: "Poster un message LinkedIn après ma mort
*/
@Controller
public class actionPosterMessageController {

    @Autowired
    private PosterMessageRepository dao;

    @Autowired
    private CompteRepository compteDao;
    
    @GetMapping(path ="addMessage")
    public String montreLeFormulairePourAjout(@ModelAttribute("PM") PosterMessage PM) {
        return "ProgrammerMessage";
    }


    @PostMapping(path = "saveMessage")
    public String ajouteLActionPuisMontreLaListe(PosterMessage PM) {
        Compte compteDeJE=compteDao.getOne(1);
        PM.setCompte(compteDeJE);
        dao.save(PM);
        return "redirect:/PageClient"; 
    }
    
    @RequestMapping(path="/PageClient")
    public String afficherPotseMessageAction(Model model){
        model.addAttribute("PosterMessageAction", dao.findAllByCompteId(1));
        return "PageClient" ;}
    
}
