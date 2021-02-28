package fr.franck.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.franck.model.Agence;
import fr.franck.service.AgenceService;

@RestController
@CrossOrigin("*")//Permet d'autoriser toutes les requetes et d'éviter les problèmes réseaux.
public class AgenceController {
	
    @Autowired//Injection par Autowired d'une instance du service, on injecte pas l'implémentation, mais l'interface Service.
    AgenceService agenceService;
   
    //Rechercher une agence par son ID.
    @CrossOrigin
    @GetMapping("/agences/{id}")
    ResponseEntity<Agence> getAgenceById(@PathVariable(value = "id") Long id) {
    	Optional<Agence> agence = agenceService.findById(id);
    	if(agence.isEmpty()) {
    		return ResponseEntity.notFound().build();
    	}
    	return ResponseEntity.ok().body(agence.get());
    }
    
    //Lister les agences.
    @CrossOrigin
    @GetMapping("/agences")
    public ResponseEntity<List<Agence>> getAllAgences(@RequestParam(value = "search", defaultValue = "") String search) {
    	List<Agence> listAgence;
    	try {
    		listAgence = agenceService.findAll(search);
    	} catch (Exception e) {
    		return ResponseEntity.notFound().build();
    	}
        return ResponseEntity.ok().body(listAgence);
    }
    

    //Ajouter une agence.
    @CrossOrigin
    @PostMapping("/agences")
    ResponseEntity<Agence> addAgence(@Valid @RequestBody Agence agence) {
    	return ResponseEntity.ok().body(agenceService.addAgence(agence));
    }

    
    //Modifier une agence.
    @CrossOrigin
    @PutMapping("/agences/{id}")
    ResponseEntity<Agence> updateAgence(@PathVariable(value="id") Long id, @Valid @RequestBody Agence agence){
        Agence updatedAgence = agenceService.updateAgence(id, agence);
        if(updatedAgence == null)
        	return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(updatedAgence);
    }
    
    //Effacer une agence.
    @CrossOrigin
    @DeleteMapping("/agences/{id}")
    ResponseEntity<Agence> deleteAgence(@PathVariable(value="id") Long id) {
    	Optional<Agence> agence = agenceService.findById(id);
    	if(agence.isEmpty())
    		return ResponseEntity.notFound().build();
    	
    	agenceService.deleteAgence(agence.get().getId());
    	return ResponseEntity.accepted().build();
    }

}
