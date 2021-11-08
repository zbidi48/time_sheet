package tn.esprit.spring.TestController;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
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
	private static final Logger logger = Logger.getLogger(TestRestControllerEntreprise.class);
	RestControlEntreprise testrstcnt = new RestControlEntreprise();

	@Autowired
	private ContratServiceImpl contrat;

	@Autowired
	private EntrepriseRepository repo;

	@Test
	void testajoutentrep() {
		System.out.println(contrat);
		System.out.println(repo);
		try {
			logger.info("lancement de testajout : ");
			Entreprise entrp = new Entreprise("BTIC", "boite dev");
			logger.info("enregistrement de ligne dans la base : ");

			Entreprise saveentrp = repo.save(entrp);
			assertNotNull(saveentrp);

		} catch (Exception e) {
			logger.error("Erreur dans le test d'ajout) : " + e);

		}

	}

	@Test

	void testupdateentrep() {
		String newname = "vermeg";
		try
		{
			logger.info("mise a jour de nom entreprise");
			Entreprise entrp = new Entreprise(newname, "boite dev");
			logger.info("enregistremnt de ligne");
			
			
			repo.save(entrp);
			logger.debug("test d egualite.");

			assertThat(entrp.getName()).isEqualTo(newname);
			
		}catch (Exception e) {
			logger.warn("mise a jour echoue"+e);
		}
		
	}

	@Test
	@Rollback(false)
	void deleteentrptest() {
		int id = 1;
		try
		{
			boolean isexistbefor = repo.findById(id).isPresent();
			if (isexistbefor) {
				repo.deleteById(id);
				logger.info("test d existance");
				boolean notexistafterdelete = repo.findById(id).isPresent();
				logger.debug("test existance avant et apres");
				assertTrue(isexistbefor);
				assertFalse(notexistafterdelete);
			}

		}catch (Exception e) {
			logger.error("l element existe"+e);
		}
	}

}