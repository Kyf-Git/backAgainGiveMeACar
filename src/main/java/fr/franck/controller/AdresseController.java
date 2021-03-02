package fr.franck.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.franck.model.Adresse;
import fr.franck.service.AdresseService;

@RestController
@CrossOrigin("*")
public class AdresseController {
	
	@Autowired
	AdresseService adresseService;

    //Lister les adresses des agences.
    @CrossOrigin
    @GetMapping("/adresses")
    public ResponseEntity<List<Adresse>> getAllAdresse(@RequestParam(value = "search", defaultValue = "")String search) {
    	List<Adresse> listAdresse;
    	try {
    		listAdresse = adresseService.findAllAdresse(search);
    	} catch (Exception e) {
    		return ResponseEntity.notFound().build();
    	}
        return ResponseEntity.ok().body(listAdresse);
    }
	
}
