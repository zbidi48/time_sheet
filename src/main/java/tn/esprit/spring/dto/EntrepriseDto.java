package tn.esprit.spring.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class EntrepriseDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3152690779535828408L;



	private int id;
	
	private String name;
	
	
	private String raisonSocial;


	private List<DepartementDto> departements = new ArrayList<>();

	public EntrepriseDto() {
		super();
	}

	public EntrepriseDto(String name, String raisonSocial) {
		this.name = name;
		this.raisonSocial = raisonSocial;
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

	public String getRaisonSocial() {
		return raisonSocial;
	}

	public void setRaisonSocial(String raisonSocial) {
		this.raisonSocial = raisonSocial;
	}

	public List<DepartementDto> getDepartements() {
		return departements;
	}

	public void setDepartements(List<DepartementDto> departements) {
		this.departements = departements;
	}
	
	
	public void addDepartement(DepartementDto departement){
		departement.setEntreprise(this);
		this.departements.add(departement);
	}




}
