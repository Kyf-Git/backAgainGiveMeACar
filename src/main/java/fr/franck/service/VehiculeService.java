package fr.franck.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.franck.model.Vehicule;

@Service
public interface VehiculeService {


	Optional<Vehicule> findById(Long id);
	List<Vehicule> findAll(String search);
	List<Vehicule> findByAgence(Long id);
	Vehicule insert(Vehicule vehicule);
	Vehicule update(Long id, Vehicule vehicule);
	void delete(Long id);
	
}
