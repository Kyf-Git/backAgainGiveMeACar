package fr.franck.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.franck.model.Agence;
import fr.franck.repository.AgenceRepository;

@Service
public class AgenceServiceImpl implements AgenceService {

	@Autowired//Injection par Autowired du Repository, permettant ainsi de le lier à la BDD.
	private AgenceRepository agenceRepository;
	
	//Requete GET
	@Override
	public Optional<Agence> findById (Long id) {
		return agenceRepository.findById(id);
	}
	
	//Requete GET
    @Override
    public List<Agence> findAll(String search) {
        if(! "".equals(search))
        	return agenceRepository.findByNomContaining(search);
        else
        	return agenceRepository.findAll();
    }
    
    //Requete POST
    @Override
    public Agence addAgence(Agence agence) {
        Agence addingAgence = agenceRepository.save(agence);
        return addingAgence;
    }
    
    //Sans cette méthode, la requete PUT et DELETE genere une erreur.
    @Override
    public Optional<Agence> getAgence(Long id) {
        return agenceRepository.findById(id);
    }
    
    //Requete PUT
    @Override
    public Agence updateAgence(Long id, Agence agence) {
        Optional<Agence> optionalAgence = this.getAgence(id);
        if(optionalAgence.isPresent()){
            return agenceRepository.save(agence);
        }
    return null;
    }
    
    //Requete DELETE
    @Override
    public Agence deleteAgence(Long id) {
        Optional<Agence> agence = this.findById(id);
        if(agence.isPresent()){
           agenceRepository.delete(agence.get());
        }
        return null;
    }
    
}
