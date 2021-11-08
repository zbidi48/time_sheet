package tn.esprit.spring.dto;

import java.io.Serializable;
import java.util.Date;



public class ContratDto implements Serializable {

	private static final long serialVersionUID = 6191889143079517027L;


	private int reference;

	private Date dateDebut;

	private String typeContrat;

	private EmployeDto employe;

	private float salaire;

	public ContratDto() {
		super();
	}

	public ContratDto(Date dateDebut, String typeContrat, float salaire) {
		this.dateDebut = dateDebut;
		this.typeContrat = typeContrat;
		this.salaire = salaire;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public int getReference() {
		return reference;
	}

	public void setReference(int reference) {
		this.reference = reference;
	}

	public String getTypeContrat() {
		return typeContrat;
	}

	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}

	public float getSalaire() {
		return salaire;
	}

	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}

	public EmployeDto getEmploye() {
		return employe;
	}

	public void setEmploye(EmployeDto employe) {
		this.employe = employe;
	}

}
