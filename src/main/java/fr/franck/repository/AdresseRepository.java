package fr.franck.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.franck.model.Adresse;

@Repository
public interface AdresseRepository extends JpaRepository<Adresse, Long> {
	
	List<Adresse> findAll();
}
