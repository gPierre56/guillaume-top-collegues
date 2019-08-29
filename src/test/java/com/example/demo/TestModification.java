/**
 * 
 */
package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.UUID;

import org.junit.Test;

import com.diginamic.main.dto.CollegueEmailDTO;
import com.diginamic.main.dto.CollegueUrlDto;
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

		assertThat(service.modifierEmail(c.getMatricule(), new CollegueEmailDTO("test@test.fr")).getEmail())
				.isEqualTo("test@test.fr");

	}

	@Test(expected = CollegueInvalideException.class)
	public void testModificationEmailExceptionInvalide() throws CollegueNonTrouveException, CollegueInvalideException {
		CollegueService service = new CollegueService();
		Collegue c = new Collegue(UUID.randomUUID().toString(), "fzfzeze", "yuuyvyugy", "fekjberkjbzrfzef.fr",
				LocalDate.of(1970, 2, 3), "http://www.nioutaik.fr/images/galerie/fail%2002.jpg");
		service.setData(new HashMap<String, Collegue>());
		service.getData().put(c.getMatricule(), c);

		service.modifierEmail(c.getMatricule(), new CollegueEmailDTO("testtest.fr"));

	}

	@Test(expected = CollegueNonTrouveException.class)
	public void testModificationEmailExceptionIntrouvable()
			throws CollegueNonTrouveException, CollegueInvalideException {
		CollegueService service = new CollegueService();
		Collegue c = new Collegue(UUID.randomUUID().toString(), "fzfzeze", "yuuyvyugy", "fekjberkjb@zrfzef.fr",
				LocalDate.of(1970, 2, 3), "http://www.nioutaik.fr/images/galerie/fail%2002.jpg");
		service.setData(new HashMap<String, Collegue>());
		service.getData().put(c.getMatricule(), c);

		service.modifierEmail("dgthrttr", new CollegueEmailDTO("test@test.fr"));

	}

	@Test
	public void testModificationUrlPhoto() throws CollegueNonTrouveException, CollegueInvalideException {
		CollegueService service = new CollegueService();
		Collegue c = new Collegue(UUID.randomUUID().toString(), "fzfzeze", "yuuyvyugy", "fekjberkjb@zrfzef.fr",
				LocalDate.of(1970, 2, 3), "http://www.nioutaik.fr/images/galerie/fail%2002.jpg");
		service.setData(new HashMap<String, Collegue>());
		service.getData().put(c.getMatricule(), c);

		assertThat(service.modifierPhotoUrl(c.getMatricule(), new CollegueUrlDto("http://eifbzeuyg")).getPhotoUrl())
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

		service.modifierPhotoUrl(c.getMatricule(), new CollegueUrlDto("htefetp://eifbzeuyg"));

	}

	@Test(expected = CollegueNonTrouveException.class)
	public void testModificationUrlPhotoExceptionIntrouvable()
			throws CollegueNonTrouveException, CollegueInvalideException {
		CollegueService service = new CollegueService();
		Collegue c = new Collegue(UUID.randomUUID().toString(), "fzfzeze", "yuuyvyugy", "fekjberkjb@zrfzef.fr",
				LocalDate.of(1970, 2, 3), "http://www.nioutaik.fr/images/galerie/fail%2002.jpg");
		service.setData(new HashMap<String, Collegue>());
		service.getData().put(c.getMatricule(), c);

		service.modifierPhotoUrl("tghrtg", new CollegueUrlDto("http://eifbzeuyg"));

	}

}
