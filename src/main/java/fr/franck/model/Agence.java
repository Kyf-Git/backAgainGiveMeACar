package fr.franck.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Agence {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)//Permet de créer un nouvel ID à chaque nouvelle Agence créée
	private Long id;
	
	private String nom;
	
    //permet de référencer l'adresse de l'autre coté.
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="adresse_id")
    private Adresse adresse;

    //permet de référencer les vehicules.
    @OneToMany(mappedBy="agence")
	@JsonBackReference
    private List<Vehicule> vehicule;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Vehicule> getVehicule() {
		return vehicule;
	}

	public void setVehicule(List<Vehicule> vehicule) {
		this.vehicule = vehicule;
	}
	
}
