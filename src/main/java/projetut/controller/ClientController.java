package projetut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import projetut.dao.ClientRepository;

@Controller
public class ClientController {
    
    @Autowired
    ClientRepository clientDao;
    
    @GetMapping("/PageClient")
    public String affichageDelaListeDesClientsDansLaPageClient(Model model) {
        model.addAttribute("clients", clientDao.findAll());
        return "PageClient";
    }
}
