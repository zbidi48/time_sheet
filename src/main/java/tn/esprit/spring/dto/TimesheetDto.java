package tn.esprit.spring.dto;

import java.io.Serializable;


public class TimesheetDto implements Serializable{

	private static final long serialVersionUID = 3876346912862238239L;

	
	private TimesheetPKDto timesheetPK;
	
	private MissionDto mission;

	private EmployeDto employe;
	
	private boolean isValide;
	

	public boolean isValide() {
		return isValide;
	}

	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}

	public TimesheetPKDto getTimesheetPK() {
		return timesheetPK;
	}

	public void setTimesheetPK(TimesheetPKDto timesheetPK) {
		this.timesheetPK = timesheetPK;
	}

	public MissionDto getMission() {
		return mission;
	}

	public void setMission(MissionDto mission) {
		this.mission = mission;
	}

	public EmployeDto getEmploye() {
		return employe;
	}

	public void setEmploye(EmployeDto employe) {
		this.employe = employe;
	}

	
	
}
