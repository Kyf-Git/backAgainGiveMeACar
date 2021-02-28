package fr.franck.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.franck.model.Agence;

@Service
public interface AgenceService {
	
	
	Optional<Agence> findById(Long id);//Requete GET
    List<Agence> findAll(String search);//Requete GET
    Agence addAgence(Agence agence);//Requete POST
    //Optional<Agence> getAgence(Long id);//Sans cette méthode, la requete PUT et DELETE genere une erreur.
    Agence updateAgence(Long id, Agence agence);//Requete PUT
    Agence deleteAgence(Long id);//Requete DELETE
}
