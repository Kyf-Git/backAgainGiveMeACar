package fr.franck.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.franck.model.Adresse;

@Service
public interface AdresseService {

	//Requete GET
    List<Adresse> findAllAdresse(String search);
}
