/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetut.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mapController {
    
        @GetMapping("/Identification")
    public String redirectPageIdentity(){
        return "Identification";
    }
    
    @GetMapping(path="/erreur")
    public String redirecterror(){
        return "PageDerreur";
    }
    @GetMapping(path="/aproposde")
    public String redirectaproposde(){
        return "Apropos";
    }
    
    @GetMapping(path="/CallBack")
    public String redirectCallBack(){
        return "CallBack";
    }
    
    @GetMapping(path="PageAnge")
    public String resirectPageAnge(){
        return "PageAnge";
    }
    

}
