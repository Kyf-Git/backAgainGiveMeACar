package fr.franck.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.franck.model.Agence;

@Repository
public interface AgenceRepository extends JpaRepository<Agence, Long> {

	public List<Agence> findByNomContaining(String nom);
	
}
