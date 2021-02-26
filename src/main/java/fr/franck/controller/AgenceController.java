package fr.franck.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.franck.model.Agence;
import fr.franck.service.AgenceService;

@RestController
@CrossOrigin("*")//Permet d'autoriser toutes les requetes et d'éviter les problèmes réseaux.
public class AgenceController {
	
    @Autowired//Injection par Autowired d'une instance du service, on injecte pas l'implémentation, mais l'interface Service.
    AgenceService agenceService;
   
    //Lister les agences par leur ID.
    @GetMapping("/agences")
    public List<Agence> getAllAgences() {
        return agenceService.listAllAgence();
    }
    

    //Ajouter une agence.
    @PostMapping("/agences")
    @ResponseBody // récupération du json
    public String ajouterAgence(@RequestBody Agence agence){
        agenceService.ajouterAgence(agence);
        final String ajoutReussi = "Well done!";
        return ajoutReussi;
    }
    
    //Modifier une agence.
    @PutMapping("/agences/{id}")
    @ResponseBody
    public Agence modifierAgence(@PathVariable(value="id") Long id,@RequestBody Agence agence){
        return agenceService.updateAgence(id, agence);
    }
    
    //Effacer une agence.
    @DeleteMapping("/agences/{id}")
    public Agence deleteAgence(@PathVariable(value="id") Long id) {
    	return agenceService.deleteAgence(id);
    }

}
