package fr.franck.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.franck.model.Vehicule;
import fr.franck.repository.VehiculeRepository;

@Service
public class VehiculeServiceImpl implements VehiculeService{

	@Autowired
	private VehiculeRepository vehiculeRepository;
	
	
	@Override
	public Optional<Vehicule> findById (Long id) {
		return vehiculeRepository.findById(id);
	}
	
	@Override
	public List<Vehicule> findAll(String search) {
		if (! "".equals(search))
			return vehiculeRepository.findByModeleContaining(search);
		else
			return vehiculeRepository.findAll();
	}
	
	@Override
	public List<Vehicule> findByAgence(Long id) {
		return vehiculeRepository.findByAgenceId(id);
	}
	
	@Override
	public Vehicule insert(Vehicule vehicule) {
		return vehiculeRepository.save(vehicule);
	}
	
	@Override
	public Vehicule update(Long id, Vehicule vehicule) {
		Optional<Vehicule> optionalVehicule = this.findById(id);
		if(optionalVehicule.isPresent()) {
			return vehiculeRepository.save(vehicule);
		}
		return null;
	}
	
	@Override
	public void delete(Long id) {
		Optional<Vehicule> vehicule = this.findById(id);
		if (vehicule.isPresent()) {
			vehiculeRepository.delete(vehicule.get());
		}
	}
	
}
