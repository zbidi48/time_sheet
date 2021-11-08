package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {

	@Autowired
    EntrepriseRepository entrepriseRepoistory;
	@Autowired
	DepartementRepository deptRepoistory;
	
	public int ajouterEntreprise(Entreprise entreprise) {
		entrepriseRepoistory.save(entreprise);
		return entreprise.getId();
	}

	public int ajouterDepartement(Departement dep) {
		deptRepoistory.save(dep);
		return dep.getId();
	}
	
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		
				Optional<Entreprise> entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId);
				Optional<Departement> depManagedEntity = deptRepoistory.findById(depId);
				if(entrepriseManagedEntity.isPresent()&&depManagedEntity.isPresent())
					
				{
					Entreprise ent = entrepriseManagedEntity.get();
					Departement dpt=depManagedEntity.get();
					
					dpt.setEntreprise(ent);
					
					deptRepoistory.save(dpt);
				}
				
				
		
	}
	
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		Optional<Entreprise> entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId);
		List<String> depNames = new ArrayList<>();
		if(entrepriseManagedEntity.isPresent() )
		{
			Entreprise e=entrepriseManagedEntity.get();
			
			for(Departement dep : e.getDepartements()){
				depNames.add(dep.getName());
			}
		}
		
		return depNames;
	}

	@Transactional
	public void deleteEntrepriseById(int entrepriseId) {
		
		Optional<Entreprise> entrep=entrepriseRepoistory.findById(entrepriseId);
		if(entrep.isPresent())
		{
			Entreprise ent1 = entrep.get();
			entrepriseRepoistory.delete(ent1);
			}
		
		
		
	}

	@Transactional
	public void deleteDepartementById(int depId) {
		Optional<Departement> depart=deptRepoistory.findById(depId);
		if(depart.isPresent())
		{
			Departement d =depart.get();
			deptRepoistory.delete(d);	
			
		}
			
		
		
		
	}


	public Entreprise getEntrepriseById(int entrepriseId) {
		Optional<Entreprise> entrep =entrepriseRepoistory.findById(entrepriseId);
		if(entrep.isPresent())
		{
			return entrep.get();
			
		}
		else
		{
			return null;
		}
		
		
	}

}
