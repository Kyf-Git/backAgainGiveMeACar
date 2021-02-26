package fr.franck.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.franck.model.Agence;

@Service
public interface AgenceService {
	
	//Requete GET
	Optional<Agence> findById(Long id);
	
	//Requete GET
    List<Agence> findAll(String search);
    
    //Requete POST
    Agence addAgence(Agence agence);
    
    //Sans cette méthode, la requete PUT et DELETE genere une erreur.
    Optional<Agence> getAgence(Long id);
    
    //Requete PUT
    Agence updateAgence(Long id, Agence agence);
    
    //Requete DELETE
    Agence deleteAgence(Long id);
}
