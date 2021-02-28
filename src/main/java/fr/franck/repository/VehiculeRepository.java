package fr.franck.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.franck.model.Vehicule;

public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
	
	public List<Vehicule> findByModeleContaining(String modele);
	public List<Vehicule> findByAgenceId(Long id);

}
