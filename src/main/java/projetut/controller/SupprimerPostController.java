
package projetut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import projetut.dao.CompteRepository;
import projetut.dao.SupprimerPostRepository;
import projetut.entity.Compte;
import projetut.entity.SupprimerPost;

@Controller
public class SupprimerPostController {
    
    @Autowired
    private SupprimerPostRepository dao;

    @Autowired
    private CompteRepository compteDao;
    
    @GetMapping(path = "addSuppr")
    public String montreLeFormulairePourAjout(@ModelAttribute("SP") SupprimerPost SP) {
        return "SupprimerMessage";
    }


    @PostMapping(path = "saveSuppr")
    public String ajouteLActionPuisMontreLaListe(SupprimerPost SP) {
        Compte compteDeJE=compteDao.getOne(1);
        SP.setCompte(compteDeJE);
        dao.save(SP);
        return "redirect:/PageClient"; 
    }
    
}
