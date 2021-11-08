package tn.esprit.spring.dto;

import java.io.Serializable;
import java.util.List;


public class MissionDto implements Serializable {

	private static final long serialVersionUID = -5369734855993305723L;

	
	private int id;
	
	private String name;
	
	private String description;


	private DepartementDto departement;


	private  List<TimesheetDto> timesheets;
	
	public  MissionDto() {
		super();
	}

	public MissionDto(String name, String description){
		this.name = name;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DepartementDto getDepartement() {
		return departement;
	}

	public void setDepartement(DepartementDto departement) {
		this.departement = departement;
	}

	public List<TimesheetDto> getTimesheets() {
		return timesheets;
	}

	public void setTimesheets(List<TimesheetDto> timesheets) {
		this.timesheets = timesheets;
	}
	
	

}
