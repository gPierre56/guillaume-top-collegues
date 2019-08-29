/**
 * 
 */
package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.UUID;

import org.junit.Test;

import com.diginamic.main.exception.CollegueInvalideException;
import com.diginamic.main.exception.CollegueNonTrouveException;
import com.diginamic.main.model.Collegue;
import com.diginamic.main.service.CollegueService;

/**
 * @author Guillaume
 *
 */
public class TestModification {

	@Test
	public void testModificationEmail() throws CollegueNonTrouveException, CollegueInvalideException {
		CollegueService service = new CollegueService();
		Collegue c = new Collegue(UUID.randomUUID().toString(), "fzfzeze", "yuuyvyugy", "fekjberkjb@zrfzef.fr",
				LocalDate.of(1970, 2, 3), "http://www.nioutaik.fr/images/galerie/fail%2002.jpg");
		service.setData(new HashMap<String, Collegue>());
		service.getData().put(c.getMatricule(), c);

		assertThat(service.modifierEmail(c.getMatricule(), "test@test").getEmail()).isEqualTo("test@test");

	}

	@Test(expected = CollegueInvalideException.class)
	public void testModificationEmailExceptionInvalide() throws CollegueNonTrouveException, CollegueInvalideException {
		CollegueService service = new CollegueService();
		Collegue c = new Collegue(UUID.randomUUID().toString(), "fzfzeze", "yuuyvyugy", "fekjberkjbzrfzef.fr",
				LocalDate.of(1970, 2, 3), "http://www.nioutaik.fr/images/galerie/fail%2002.jpg");
		service.setData(new HashMap<String, Collegue>());
		service.getData().put(c.getMatricule(), c);

		service.modifierEmail(c.getMatricule(), "testtest.fr");

	}

	@Test(expected = CollegueNonTrouveException.class)
	public void testModificationEmailExceptionIntrouvable()
			throws CollegueNonTrouveException, CollegueInvalideException {
		CollegueService service = new CollegueService();
		Collegue c = new Collegue(UUID.randomUUID().toString(), "fzfzeze", "yuuyvyugy", "fekjberkjb@zrfzef.fr",
				LocalDate.of(1970, 2, 3), "http://www.nioutaik.fr/images/galerie/fail%2002.jpg");
		service.setData(new HashMap<String, Collegue>());
		service.getData().put(c.getMatricule(), c);

		service.modifierEmail("dgthrttr", "test@test.fr");

	}

	@Test
	public void testModificationUrlPhoto() throws CollegueNonTrouveException, CollegueInvalideException {
		CollegueService service = new CollegueService();
		Collegue c = new Collegue(UUID.randomUUID().toString(), "fzfzeze", "yuuyvyugy", "fekjberkjb@zrfzef.fr",
				LocalDate.of(1970, 2, 3), "http://www.nioutaik.fr/images/galerie/fail%2002.jpg");
		service.setData(new HashMap<String, Collegue>());
		service.getData().put(c.getMatricule(), c);

		assertThat(service.modifierPhotoUrl(c.getMatricule(), "http://eifbzeuyg").getPhotoUrl())
				.isEqualTo("http://eifbzeuyg");

	}

	@Test(expected = CollegueInvalideException.class)
	public void testModificationUrlPhotoExceptionInvalide()
			throws CollegueNonTrouveException, CollegueInvalideException {
		CollegueService service = new CollegueService();
		Collegue c = new Collegue(UUID.randomUUID().toString(), "fzfzeze", "yuuyvyugy", "fekjberkjb@zrfzef.fr",
				LocalDate.of(1970, 2, 3), "http://www.nioutaik.fr/images/galerie/fail%2002.jpg");
		service.setData(new HashMap<String, Collegue>());
		service.getData().put(c.getMatricule(), c);

		service.modifierPhotoUrl(c.getMatricule(), "htefetp://eifbzeuyg");

	}

	@Test(expected = CollegueNonTrouveException.class)
	public void testModificationUrlPhotoExceptionIntrouvable()
			throws CollegueNonTrouveException, CollegueInvalideException {
		CollegueService service = new CollegueService();
		Collegue c = new Collegue(UUID.randomUUID().toString(), "fzfzeze", "yuuyvyugy", "fekjberkjb@zrfzef.fr",
				LocalDate.of(1970, 2, 3), "http://www.nioutaik.fr/images/galerie/fail%2002.jpg");
		service.setData(new HashMap<String, Collegue>());
		service.getData().put(c.getMatricule(), c);

		service.modifierPhotoUrl("tghrtg", "http://eifbzeuyg");

	}

}
