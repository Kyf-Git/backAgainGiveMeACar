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

import fr.franck.model.Vehicule;
import fr.franck.service.VehiculeService;

@RestController
@CrossOrigin("*")
public class VehiculeController {

	@Autowired
	VehiculeService vehiculeService;
	
	@CrossOrigin
	@GetMapping("/vehicules/{id}")
	ResponseEntity<Vehicule> getVehiculeById(@PathVariable(value = "id") Long id) {
		Optional<Vehicule> vehicule = vehiculeService.findById(id);
		if(vehicule.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(vehicule.get());
	}
	
	@CrossOrigin
	@GetMapping("/vehicules")
	public ResponseEntity<List<Vehicule>> getAllVehicules(@RequestParam(value = "search", defaultValue = "") String search) {
		List<Vehicule> listVehicule;
		try {
			listVehicule = vehiculeService.findAll(search);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(listVehicule);
	}
	
	@CrossOrigin
	@GetMapping("/agences/{id}/vehicules")
	public ResponseEntity<List<Vehicule>> getAllVehicules(@PathVariable(value = "id") Long id) {
		List<Vehicule> listVehicule;
		try {
			listVehicule = vehiculeService.findByAgence(id);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(listVehicule);
	}
	
	@CrossOrigin
	@PostMapping("/vehicules")
	ResponseEntity<Vehicule> AddVehicule(@Valid @RequestBody Vehicule vehicule) {
		return ResponseEntity.ok().body(vehiculeService.insert(vehicule));
	}
	
	@CrossOrigin
	@PutMapping("/vehicules/{id}")
	ResponseEntity<Vehicule> updateVehicule(@PathVariable(value = "id") Long id, @Valid @RequestBody Vehicule vehicule) {
		Vehicule updatedVehicule = vehiculeService.update(id, vehicule);
		if(updatedVehicule == null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok().body(updatedVehicule);
	}
	
	@CrossOrigin
	@DeleteMapping("/vehicules/{id}")
	ResponseEntity<Vehicule> deleteVehicule(@PathVariable(value = "id") Long id) {
		Optional<Vehicule> vehicule = vehiculeService.findById(id);
		if(vehicule.isEmpty())
			return ResponseEntity.notFound().build();
		
		vehiculeService.delete(vehicule.get().getId());
		return ResponseEntity.accepted().build();
	}
	
}
