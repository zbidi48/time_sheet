package tn.esprit.spring.dto;


import java.io.Serializable;
import java.util.List;


public class EmployeDto implements Serializable {
	
	private static final long serialVersionUID = -1396669830860400871L;


	private int id;
	
	private String prenom;
	
	private String nom;

	private String email;

	private String password;
	
	private boolean actif;
	
	private RoleDto role;
	
	private List<DepartementDto> departements;
	
	private ContratDto contrat;
	
	private List<TimesheetDto> timesheets;
	
	
	public EmployeDto() {
		super();
	}
	
		
	public EmployeDto(int id, String prenom, String nom, String email, String password, boolean actif, RoleDto role) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.password = password;
		this.actif = actif;
		this.role = role;
	}



	public EmployeDto(String nom, String prenom, String email, String password, boolean actif, RoleDto role) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.actif = actif;
		this.role = role;
	}
	
	public EmployeDto(String nom, String prenom, String email, boolean actif, RoleDto role) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.actif = actif;
		this.role = role;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}
	 
	public String getPassword() {
		return password;
	}
 
	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}




	public boolean isActif() {
		return actif;
	}


	public void setActif(boolean actif) {
		this.actif = actif;
	}


	public RoleDto getRole() {
		return role;
	}

	public void setRole(RoleDto role) {
		this.role = role;
	}

	public List<DepartementDto> getDepartements() {
		return departements;
	}

	public void setDepartements(List<DepartementDto> departement) {
		this.departements = departement;
	}

	public ContratDto getContrat() {
		return contrat;
	}

	public void setContrat(ContratDto contrat) {
		this.contrat = contrat;
	}

	public List<TimesheetDto> getTimesheets() {
		return timesheets;
	}

	public void setTimesheets(List<TimesheetDto> timesheets) {
		this.timesheets = timesheets;
	}


	@Override
	public String toString() {
		return "Employe [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", email=" + email + ", password="
				+ password + ", actif=" + actif + ", role=" + role + "]";
	}


	
	
}
