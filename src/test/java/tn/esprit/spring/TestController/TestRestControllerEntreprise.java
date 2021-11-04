package tn.esprit.spring.TestController;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import tn.esprit.spring.controller.RestControlEntreprise;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.EntrepriseRepository;
import tn.esprit.spring.services.ContratServiceImpl;


@ExtendWith(SpringExtension.class)
@SpringBootTest
 class TestRestControllerEntreprise {
	RestControlEntreprise testrstcnt = new RestControlEntreprise();
	
	@Autowired
	private ContratServiceImpl contrat;
	
	@Autowired
	private EntrepriseRepository repo;

	@Test
	 void testajoutentrep() {
		System.out.println(contrat);
		System.out.println(repo);
		Entreprise entrp = new Entreprise("BTIC", "boite dev");
		Entreprise saveentrp = repo.save(entrp);
		assertNotNull(saveentrp);

		// repo.save(entrp);

	}

	@Test

	 void testupdateentrep() {
		String newname = "vermeg";
		Entreprise entrp = new Entreprise(newname, "boite dev");
		// Entreprise.setId(1);
		repo.save(entrp);
		 //Entreprise updatentrep = repo.findById(entrp.getId());

		assertThat(entrp.getName()).isEqualTo(newname);
	}
	@Test
	@Rollback(false)
	 void deleteentrptest()
	{
		int id =1;
		boolean isexistbefor =repo.findById(id).isPresent();
		if(isexistbefor){
		repo.deleteById(id);
		boolean notexistafterdelete = repo.findById(id).isPresent();
		assertTrue(isexistbefor);
		assertFalse(notexistafterdelete);
		}
		
		
	}
	
}