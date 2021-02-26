package fr.franck.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.franck.model.Adresse;

public interface AdresseRepository extends JpaRepository<Adresse, Long> {
	
	List<Adresse> findAll();
}
