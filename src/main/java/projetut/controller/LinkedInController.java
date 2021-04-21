package projetut.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.linkedin.api.LinkedIn;
import org.springframework.social.linkedin.api.ProfileOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Slf4j
@RequestMapping("/linkedin")
public class LinkedInController {

    @Value("${spring.social.linkedin.consumerKey}")
    String clientId;
    @Value("${spring.social.linkedin.consumerSecret}")
    String clientSecret;

    private ConnectionRepository connectionRepository;

    public LinkedInController(ConnectionRepository connectionRepository) {
        this.connectionRepository = connectionRepository;
    }

    @GetMapping
    public String helloLinkedIn(Model model) {
        Connection<LinkedIn> connection = connectionRepository.findPrimaryConnection(LinkedIn.class);
        if (connection == null) {   
            return "redirect:/connect/linkedin";
        }
        LinkedIn linkedIn=connection.getApi();
        
        ProfileOperations user = linkedIn.profileOperations();
        System.out.println(user);
        model.addAttribute("linkedInProfile",linkedIn.profileOperations().getUserProfileFull());
        
        return "linkedin";
    }
    
    //TODO: Il faut trouver le moyen de modifier les paramètres de requête par défault 
    //Puis enregistré le client et son compte linkedin à l'ai du code ci-dessus

}
