package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.TimesheetRepository;

@Service
public class EmployeServiceImpl implements IEmployeService {

	private static final Logger logger = Logger.getLogger(EmployeServiceImpl.class);
	
	@Autowired
	EmployeRepository employeRepository;
	@Autowired
	DepartementRepository deptRepoistory;
	@Autowired
	ContratRepository contratRepoistory;
	@Autowired
	TimesheetRepository timesheetRepository;

	@Override
	public Employe authenticate(String login, String password) {
		return employeRepository.getEmployeByEmailAndPassword(login, password);
	}

	@Override
	public int addOrUpdateEmploye(Employe employe) {
		employeRepository.save(employe);
		return employe.getId();
	}

	public void mettreAjourEmailByEmployeId(String email, int employeId) {
		Optional<Employe> employe = employeRepository.findById(employeId);
		if (employe.isPresent()) {
			Employe e = employe.get();
			e.setEmail(email);
			employeRepository.save(e);

		} else {
			logger.info("impossible to update");
		}

	}

	@Transactional
	public void affecterEmployeADepartement(int employeId, int depId) {
		Departement d = null;
		Employe e = null;
		Optional<Departement> depManagedEntity = deptRepoistory.findById(depId);
		Optional<Employe> employeManagedEntity = employeRepository.findById(employeId);
		if (depManagedEntity.isPresent() && employeManagedEntity.isPresent()) {
			d = depManagedEntity.get();
			e = employeManagedEntity.get();
			if (d.getEmployes() == null) {

				List<Employe> employes = new ArrayList<>();
				employes.add(e);
				d.setEmployes(employes);
			} else {

				d.getEmployes().add(e);
			}
			
			deptRepoistory.save(d);
		}

		

	}

	@Transactional
	public void desaffecterEmployeDuDepartement(int employeId, int depId) {
		Departement d = null;
		Optional<Departement> dep = deptRepoistory.findById(depId);
		if (dep.isPresent()) {
			d = dep.get();
			int employeNb = d.getEmployes().size();
			for (int index = 0; index < employeNb; index++) {
				if (d.getEmployes().get(index).getId() == employeId) {
					d.getEmployes().remove(index);
					break;
				}
			}

		} else {
			logger.info("affectation  n est pas effectue ");
		}

	}

	public int ajouterContrat(Contrat contrat) {
		contratRepoistory.save(contrat);
		return contrat.getReference();
	}

	public void affecterContratAEmploye(int contratId, int employeId) {
		Contrat c = null;
		Optional<Contrat> contratManagedEntity = contratRepoistory.findById(contratId);
		
		Employe e = null;
		Optional<Employe> employeManagedEntity = employeRepository.findById(employeId);
		
		if (employeManagedEntity.isPresent() && contratManagedEntity.isPresent()) {
			c = contratManagedEntity.get();
			e = employeManagedEntity.get();
			c.setEmploye(e);
			contratRepoistory.save(c);
		}

	


	}

	public String getEmployePrenomById(int employeId) {

		Optional<Employe> employeManagedEntity = employeRepository.findById(employeId);
		if (employeManagedEntity.isPresent()) {
			Employe e = employeManagedEntity.get();
			return e.getPrenom();
		} else {
			return "not found";
		}
	}

	public void deleteEmployeById(int employeId) {
		Employe em = null;
		Optional<Employe> employe = employeRepository.findById(employeId);
		if (employe.isPresent()) {
			em = employe.get();
		
			for (Departement dep : em.getDepartements()) {
				dep.getEmployes().remove(em);
			}
			
			employeRepository.delete(em);
		}

		
	}

	public void deleteContratById(int contratId) {
		
		Optional<Contrat> contratManagedEntity = contratRepoistory.findById(contratId);
		if (contratManagedEntity.isPresent()) {
			Contrat c1 = contratManagedEntity.get();
			contratRepoistory.delete(c1);
		} else {
			logger.info("it impossible to delete");
		}

	}

	public int getNombreEmployeJPQL() {
		return employeRepository.countemp();
	}

	public List<String> getAllEmployeNamesJPQL() {
		return employeRepository.employeNames();

	}

	public List<Employe> getAllEmployeByEntreprise(Entreprise entreprise) {
		return employeRepository.getAllEmployeByEntreprisec(entreprise);
	}

	public void mettreAjourEmailByEmployeIdJPQL(String email, int employeId) {
		employeRepository.mettreAjourEmailByEmployeIdJPQL(email, employeId);

	}

	public void deleteAllContratJPQL() {
		employeRepository.deleteAllContratJPQL();
	}

	public float getSalaireByEmployeIdJPQL(int employeId) {
		return employeRepository.getSalaireByEmployeIdJPQL(employeId);
	}

	public Double getSalaireMoyenByDepartementId(int departementId) {
		return employeRepository.getSalaireMoyenByDepartementId(departementId);
	}

	public List<Timesheet> getTimesheetsByMissionAndDate(Employe employe, Mission mission, Date dateDebut,
			Date dateFin) {
		return timesheetRepository.getTimesheetsByMissionAndDate(employe, mission, dateDebut, dateFin);
	}

	public List<Employe> getAllEmployes() {
		return (List<Employe>) employeRepository.findAll();
	}

}
