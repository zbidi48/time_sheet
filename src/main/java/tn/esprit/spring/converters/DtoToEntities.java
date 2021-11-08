package tn.esprit.spring.converters;

import java.util.ArrayList;
import java.util.List;



import tn.esprit.spring.dto.ContratDto;
import tn.esprit.spring.dto.DepartementDto;
import tn.esprit.spring.dto.EmployeDto;
import tn.esprit.spring.dto.EntrepriseDto;
import tn.esprit.spring.dto.MissionDto;
import tn.esprit.spring.dto.RoleDto;
import tn.esprit.spring.dto.TimesheetDto;
import tn.esprit.spring.dto.TimesheetPKDto;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.entities.TimesheetPK;

public class DtoToEntities {

	private DtoToEntities() {}
	
	public static Contrat contratDtoToContratEntity(ContratDto c)
	{
	
		Contrat contrat = new Contrat();
		
		contrat.setDateDebut(c.getDateDebut());
		contrat.setEmploye(employeDtoToEmployeEntity(c.getEmploye()));
		contrat.setReference(c.getReference());
		contrat.setSalaire(c.getSalaire());
		contrat.setTypeContrat(c.getTypeContrat());
		
		return contrat;
	}
	
	
	public static Employe employeDtoToEmployeEntity(EmployeDto e)
	{
		Employe emp = new Employe();
		
		emp.setActif(e.isActif());
		emp.setContrat(contratDtoToContratEntity(e.getContrat()));
		emp.setDepartements(departementDtoListToDepartementEntityList(e.getDepartements()));
		emp.setEmail(e.getEmail());
		emp.setId(e.getId());
		emp.setNom(e.getNom());
		emp.setPassword(e.getPassword());
		emp.setPrenom(e.getPrenom());
		emp.setRole(roleDtoToRoleEntity(e.getRole()));
		emp.setTimesheets(timesheetDtoListToTimesheetEntityList(e.getTimesheets()));
		
		return emp;
		
	}
	
	
	public static Departement departementDtoToDepartement(DepartementDto d)
	{
		Departement dep = new Departement();
		
		dep.setEmployes(employeeDtoListToEmployeEntityList(d.getEmployes()));
		dep.setEntreprise(entrepriseDtoToEntrepriseEntity(d.getEntreprise()));
		dep.setId(d.getId());
		dep.setName(d.getName());
		dep.setMissions(missionDtoListToMissionEntityList(d.getMissions()));
		
		return dep;
	}
	
	
	
	public static Mission missionDtoToMissionEntity (MissionDto m)
	{
		Mission mis = new Mission();
		
		mis.setDepartement(departementDtoToDepartement(m.getDepartement()));
		mis.setDescription(m.getDescription());
		mis.setId(m.getId());
		mis.setName(m.getName());
		mis.setTimesheets(timesheetDtoListToTimesheetEntityList(m.getTimesheets()));

		
		return mis;
	}
	
	
	
	public static Timesheet timesheetToTimesheetDto (TimesheetDto t)
	{
		Timesheet tim = new Timesheet();
		
		tim.setEmploye(employeDtoToEmployeEntity(t.getEmploye()));
		tim.setMission(missionDtoToMissionEntity(t.getMission()));
		tim.setValide(t.isValide());
		tim.setTimesheetPK(timesheetPkToTimesheetPkDto(t.getTimesheetPK()));
		
		return tim;
	}
	
	public static TimesheetPK timesheetPkToTimesheetPkDto (TimesheetPKDto t)
	{
		TimesheetPK tim = new TimesheetPK();
		
		tim.setDateDebut(t.getDateDebut());
		tim.setDateFin(t.getDateFin());
		tim.setIdEmploye(t.getIdEmploye());
		tim.setIdMission(t.getIdMission());
		
		return tim;
	}
	
	
	
	public static Entreprise entrepriseDtoToEntrepriseEntity (EntrepriseDto e)
	{
		Entreprise ent = new Entreprise();
		
		ent.setRaisonSocial(e.getRaisonSocial());
		ent.setName(e.getName());
		ent.setId(e.getId());
		ent.setDepartements(departementDtoListToDepartementEntityList(e.getDepartements()));
		
		
		return ent;
	}
	
	
	public static List<Employe> employeeDtoListToEmployeEntityList(List<EmployeDto> l)
	{
		
		List<Employe> ls = new ArrayList<>();
		
		for (EmployeDto e : l)
		{
			ls.add(employeDtoToEmployeEntity(e));
		}
		
		return ls;
	}
	
	
	public static List<Departement> departementDtoListToDepartementEntityList(List<DepartementDto> l)
	{
		
		List<Departement> ls = new ArrayList<>();
		
		for (DepartementDto d : l)
		{
			ls.add(departementDtoToDepartement(d));
		}
		
		return ls;
	}
	
	
	public static List<Timesheet> timesheetDtoListToTimesheetEntityList(List<TimesheetDto> l)
	{
		
		List<Timesheet> ls = new ArrayList<>();
		
		for (TimesheetDto t : l)
		{
			ls.add(timesheetToTimesheetDto(t));
		}
		
		return ls;
	}
	
	
	public static List<Mission> missionDtoListToMissionEntityList(List<MissionDto> l)
	{
		
		List<Mission> ls = new ArrayList<>();
		
		for (MissionDto m : l)
		{
			ls.add(missionDtoToMissionEntity(m));
		}
		
		return ls;
	}
	
	
	public static Role roleDtoToRoleEntity(RoleDto r)
	{
		if(r.equals(RoleDto.ADMINISTRATEUR))
			return Role.ADMINISTRATEUR;
		
		if(r.equals(RoleDto.CHEF_DEPARTEMENT))
			return Role.CHEF_DEPARTEMENT;
		
		if(r.equals(RoleDto.INGENIEUR))
			return Role.INGENIEUR;
		
		if(r.equals(RoleDto.TECHNICIEN))
			return Role.TECHNICIEN;
		
		
		return null;
	}
	
}
