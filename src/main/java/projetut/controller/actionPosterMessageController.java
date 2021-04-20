/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetut.controller;

import java.rmi.UnexpectedException;
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

@Controller@RequestMapping(path="posterMessageLI")
public class actionPosterMessageController {

    @Autowired
    private PosterMessageRepository dao;

    @Autowired
    private CompteRepository compteDao;
    
    @GetMapping(path = "add")
    public String montreLeFormulairePourAjout(@ModelAttribute("PM") PosterMessage PM) {
        return "ProgrammerMessage";
    }


    @PostMapping(path = "save")
    public String ajouteLActionPuisMontreLaListe(PosterMessage PM) {
        Compte compteDeJE=compteDao.getOne(1);
        PM.setCompte(compteDeJE);
        dao.save(PM);
        return "redirect:/PageClient"; 
    }
}
