package projetut.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.linkedin.api.LinkedIn;
import org.springframework.social.linkedin.api.LinkedInProfile;
import org.springframework.social.linkedin.api.ProfileOperations;
import org.springframework.social.linkedin.api.impl.LinkedInTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import projetut.dao.CompteRepository;
import projetut.entity.CompteLinkedIN;
import projetut.entity.Client;
import projetut.dao.ClientRepository;

@Controller
@Slf4j
@RequestMapping("/linkedin")
public class CompteLinkedInController {

    @Value("${spring.social.linkedin.consumerKey}")
    String clientId;
    @Value("${spring.social.linkedin.consumerSecret}")
    String clientSecret;

    private String accessToken;

    private ConnectionRepository connectionRepository;

    @Autowired
    private CompteRepository compteDao;

    @Autowired
    private ClientRepository clientDao;

    @GetMapping("/PageClient")
    public String affichageDelaListeDesClientsDansLaPageClient(Model model) {
        model.addAttribute("clients", clientDao.findAll());
        return "PageClient";
    }

    public CompteLinkedInController(ConnectionRepository connectionRepository) {
        this.connectionRepository = connectionRepository;
    }

    private /*LinkedIn*/void configureLinkedIn() {
        /*
        Connection<LinkedIn> connection;
        connection = connectionRepository.findPrimaryConnection(LinkedIn.class);

        LinkedIn linkedIn = connection.getApi();
        log.info("Création d'une API linkedin pour {}", connection.getDisplayName());*/

        //this.accessToken = connection.createData().getAccessToken();
        this.accessToken=compteDao.findById(1).get().getAccesstoken();
        //return linkedIn;
    }

    @GetMapping
    public String helloLinkedIn(Model model) {
        Connection<LinkedIn> connection = connectionRepository.findPrimaryConnection(LinkedIn.class);
        if (connection == null) {   
            return "/connect/linkedin";
        }
        //LinkedIn linkedIn = configureLinkedIn();

        return "Indentification";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    private String creationDuCompteEtduClient() {
        this.configureLinkedIn();
        //Création de la connection LinkedIN
        //LinkedIn linkedIn = this.configureLinkedIn();
        LinkedIn linkedIn=new LinkedInTemplate(accessToken);
        //Récupération des informations de l'utilisateur
        LinkedInProfile profile = linkedIn.profileOperations().getUserProfile();

        //Récupération des infos sur le client
        String prenom = profile.getFirstName();
        String nom = profile.getLastName();

        //Récupération des infos sur le compte LinkedIn de l'utilisateur
        String idLinkedIn = profile.getId();
        String mail = profile.getEmailAddress();

        //Enregistrement du client dans la BDD
        Client client = new Client();
        client.setDead(false);
        client.setPrenom(prenom);
        client.setNom(nom);
        clientDao.save(client);

        /*//Enregistrement du compte LinkedIn dans la BDD
        CompteLinkedIN compte = new CompteLinkedIN();
        compte.setIdLinkedIn(idLinkedIn);
        compte.setAccesstoken(accessToken);
        compte.setAdresseMail(mail);
        compte.setProprietaire(client);
        compteDao.save(compte);*/
        
       
        return "Identification";
    }
}
