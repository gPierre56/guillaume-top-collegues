/**
 * 
 */
package com.diginamic.main.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.diginamic.main.exception.CollegueInvalideException;
import com.diginamic.main.exception.CollegueNonTrouveException;
import com.diginamic.main.model.Collegue;
import com.diginamic.main.repository.CollegueRepository;

/**
 * @author Guillaume
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CollegueServiceIntegrationTest {

	@Autowired
	private CollegueService service;

	@Autowired
	private CollegueRepository repository;

	/**
	 * Test method for
	 * {@link com.diginamic.main.service.CollegueService#rechercherParNom(java.lang.String)}.
	 * 
	 * @throws CollegueInvalideException
	 */
	@Test
	public void testRechercherParNom() throws CollegueInvalideException {

		List<Collegue> resultat = service.rechercherParNom("Pierre");
		assertThat(resultat.size()).isEqualTo(1);
	}

	@Test
	public void testRechercherParNomNonTrouve() throws CollegueInvalideException {

		List<Collegue> resultat = service.rechercherParNom("test2");
		assertThat(resultat.size()).isEqualTo(0);
	}

	/**
	 * Test method for
	 * {@link com.diginamic.main.service.CollegueService#rechercherParMatricule(java.lang.String)}.
	 * 
	 * @throws CollegueNonTrouveException
	 */
	@Test
	public void testRechercherParMatricule() throws CollegueNonTrouveException {

		assertThat(service.rechercherParMatricule(repository.findAll().get(0).getMatricule())).isNotNull();

	}

	@Test(expected = CollegueNonTrouveException.class)
	public void testRechercherParMatriculeNonTrouve() throws CollegueNonTrouveException {

		service.rechercherParMatricule("erghrieuhiorehfiorohioouihsdfuihzeiuhvruieh");

	}

	/**
	 * Test method for
	 * {@link com.diginamic.main.service.CollegueService#ajouterUnCollegue(com.diginamic.main.model.Collegue)}.
	 * 
	 * @throws CollegueInvalideException
	 */
	@Test
	public void testAjouterUnCollegue() throws CollegueInvalideException {

		service.ajouterUnCollegue(
				new Collegue(UUID.randomUUID().toString(), "test", "test", "test@", LocalDate.of(1970, 2, 1), "http"));
		assertThat(service.rechercherParNom("test")).isNotNull();
		assertThat(service.rechercherParNom("test").get(0).getMatricule()).isNotNull();
	}

	@Test(expected = CollegueInvalideException.class)
	public void testAjouterUnCollegueEmailInvalide() throws CollegueInvalideException {

		service.ajouterUnCollegue(
				new Collegue(UUID.randomUUID().toString(), "test", "test", "test", LocalDate.of(1970, 2, 1), "http"));

	}

	@Test(expected = CollegueInvalideException.class)
	public void testAjouterUnCollegueNomInvalide() throws CollegueInvalideException {

		service.ajouterUnCollegue(
				new Collegue(UUID.randomUUID().toString(), "a", "test", "te@st", LocalDate.of(1970, 2, 1), "http"));

	}

	@Test(expected = CollegueInvalideException.class)
	public void testAjouterUnColleguePrénomInvalide() throws CollegueInvalideException {

		service.ajouterUnCollegue(
				new Collegue(UUID.randomUUID().toString(), "azefzez", "t", "te@st", LocalDate.of(1970, 2, 1), "http"));

	}

	@Test(expected = CollegueInvalideException.class)
	public void testAjouterUnCollegueAgeInvalide() throws CollegueInvalideException {

		service.ajouterUnCollegue(new Collegue(UUID.randomUUID().toString(), "azefzez", "dssdfsft", "te@st",
				LocalDate.of(2019, 2, 1), "http"));

	}

	@Test(expected = CollegueInvalideException.class)
	public void testAjouterUnCollegueUrlInvalide() throws CollegueInvalideException {

		service.ajouterUnCollegue(new Collegue(UUID.randomUUID().toString(), "azefzez", "dssdfsft", "te@st",
				LocalDate.of(1970, 2, 1), "httregrg"));

	}

	/**
	 * Test method for
	 * {@link com.diginamic.main.service.CollegueService#modifierEmail(java.lang.String, java.lang.String)}.
	 * 
	 * @throws CollegueInvalideException
	 * @throws CollegueNonTrouveException
	 */
	@Test
	public void testModifierEmail() throws CollegueNonTrouveException, CollegueInvalideException {
		service.modifierEmail(repository.findAll().get(0).getMatricule(), "rhgbrjheb@");
		assertThat(repository.findAll().get(0).getEmail()).isEqualTo("rhgbrjheb@");
	}

	@Test(expected = CollegueInvalideException.class)
	public void testModifierEmailInvalide() throws CollegueNonTrouveException, CollegueInvalideException {
		service.modifierEmail(repository.findAll().get(0).getMatricule(), "rhgbrjheb");

	}

	@Test(expected = CollegueNonTrouveException.class)
	public void testModifierEmailCollegueNonTrouve() throws CollegueNonTrouveException, CollegueInvalideException {
		service.modifierEmail("existepas", "rhgb@rjheb");

	}

	/**
	 * Test method for
	 * {@link com.diginamic.main.service.CollegueService#modifierPhotoUrl(java.lang.String, java.lang.String)}.
	 * 
	 * @throws CollegueInvalideException
	 * @throws CollegueNonTrouveException
	 */
	@Test
	public void testModifierPhotoUrl() throws CollegueNonTrouveException, CollegueInvalideException {
		service.modifierPhotoUrl(repository.findAll().get(0).getMatricule(), "httpvbuibuihe");
		assertThat(repository.findAll().get(0).getPhotoUrl()).isEqualTo("httpvbuibuihe");
	}

	@Test(expected = CollegueInvalideException.class)
	public void testModifierPhotoUrlInvalide() throws CollegueNonTrouveException, CollegueInvalideException {
		service.modifierPhotoUrl(repository.findAll().get(0).getMatricule(), "ttpvbuibuihe");

	}

	@Test(expected = CollegueNonTrouveException.class)
	public void testModifierPhotoUrlCollegueNonTrouve() throws CollegueNonTrouveException, CollegueInvalideException {
		service.modifierPhotoUrl("existepas", "httpvbuibuihe");

	}

}
