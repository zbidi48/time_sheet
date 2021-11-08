package tn.esprit.spring.dto;

import java.io.Serializable;
import java.util.List;


public class DepartementDto implements Serializable {

	private static final long serialVersionUID = -357738161698377833L;

	private int id;
	
	private String name;
	
	private List<EmployeDto> employes;
	
	private List<MissionDto> missions;
	
	private EntrepriseDto entreprise;

	public DepartementDto() {
		super();
	}
	
	public DepartementDto(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EmployeDto> getEmployes() {
		return employes;
	}

	public void setEmployes(List<EmployeDto> employes) {
		this.employes = employes;
	}

	public List<MissionDto> getMissions() {
		return missions;
	}

	public void setMissions(List<MissionDto> missions) {
		this.missions = missions;
	}

	public EntrepriseDto getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(EntrepriseDto entreprise) {
		this.entreprise = entreprise;
	}
	
	

}
