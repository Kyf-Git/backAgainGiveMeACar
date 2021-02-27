package fr.franck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.franck.model.Adresse;
import fr.franck.repository.AdresseRepository;


@Service
public class AdresseServiceImpl implements AdresseService {

	@Autowired//Injection par Autowired du Repository, permettant ainsi de le lier à la BDD.
	private AdresseRepository adresseRepository;
	
	//Requete GET
    @Override
    public List<Adresse> findAll(String search) {
        	return adresseRepository.findAll();
    }
}
