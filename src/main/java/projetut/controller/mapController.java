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
    
        @GetMapping("/Identitfication")
    public String redirectPageIdentity(){
        return "Identification";
    }
    
       @GetMapping(path="/PageAnge")
    public String redirectIdentificationPageAnge(){
        return "PageAnge";
    }
    
    @GetMapping(path="/error")
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
    

}
