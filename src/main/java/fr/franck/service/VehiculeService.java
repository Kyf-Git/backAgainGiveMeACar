package fr.franck.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.franck.model.Vehicule;

@Service
public interface VehiculeService {

	//Requete GET
	List<Vehicule> listAllVehicule();
	
}
