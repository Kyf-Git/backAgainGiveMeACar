package fr.franck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.franck.model.Vehicule;
import fr.franck.repository.VehiculeRepository;

public class VehiculeServiceImpl implements VehiculeService{

	@Autowired
	private VehiculeRepository vehiculeRepository;
	
	//Requete GET
	public 	List<Vehicule> listAllVehicule() {
		return vehiculeRepository.findAll();
	}
}
