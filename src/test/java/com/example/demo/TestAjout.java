/**
 * 
 */
package com.example.demo;

import java.time.LocalDate;

import org.junit.Test;

import com.diginamic.main.exception.CollegueInvalideException;
import com.diginamic.main.model.Collegue;
import com.diginamic.main.service.CollegueService;

/**
 * @author Guillaume
 *
 */
public class TestAjout {

//	@Test
//	public void testAjout() {
//		CollegueService service = new CollegueService();
//		int indexDepart = service.getData().size();
//		int indexFin = service.getData().size() + 1;
//
//		Collegue c = new Collegue("fzfzeze", "yuuyvyugy", "fekjberkjb@zrfzef.fr", LocalDate.of(1970, 2, 3),
//				"http://www.nioutaik.fr/images/galerie/fail%2002.jpg");
//		try {
//			service.ajouterUnCollegue(c);
//			assertThat(service.getData().size() == indexFin);
//			assertThat(service.ajouterUnCollegue(c).getMatricule() != null);
//
//		} catch (CollegueInvalideException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	@Test(expected = CollegueInvalideException.class)
	public void testAjoutExceptionEmail() throws CollegueInvalideException {
		CollegueService service = new CollegueService();
		Collegue c = new Collegue("fzfzeze", "yuuyvyugy", "fekjberkjbzrfzef.fr", LocalDate.of(1970, 2, 3),
				"http://www.nioutaik.fr/images/galerie/fail%2002.jpg");
		service.ajouterUnCollegue(c);
	}

	@Test(expected = CollegueInvalideException.class)
	public void testAjoutExceptionNom() throws CollegueInvalideException {
		CollegueService service = new CollegueService();
		Collegue c = new Collegue("i", "yuuyvyugy", "fekjberk@jbzrfzef.fr", LocalDate.of(1970, 2, 3),
				"http://www.nioutaik.fr/images/galerie/fail%2002.jpg");
		service.ajouterUnCollegue(c);
	}

	@Test(expected = CollegueInvalideException.class)
	public void testAjoutExceptionPrenom() throws CollegueInvalideException {
		CollegueService service = new CollegueService();
		Collegue c = new Collegue("ifgreg", "i", "fekjberk@jbzrfzef.fr", LocalDate.of(1970, 2, 3),
				"http://www.nioutaik.fr/images/galerie/fail%2002.jpg");
		service.ajouterUnCollegue(c);
	}

	@Test(expected = CollegueInvalideException.class)
	public void testAjoutExceptionAge() throws CollegueInvalideException {
		CollegueService service = new CollegueService();
		Collegue c = new Collegue("ifgreg", "ifgzr", "fekjberk@jbzrfzef.fr", LocalDate.of(2015, 2, 3),
				"http://www.nioutaik.fr/images/galerie/fail%2002.jpg");
		service.ajouterUnCollegue(c);
	}

	@Test(expected = CollegueInvalideException.class)
	public void testAjoutExceptionImage() throws CollegueInvalideException {
		CollegueService service = new CollegueService();
		Collegue c = new Collegue("ifgreg", "ifefzfz", "fekjberk@jbzrfzef.fr", LocalDate.of(1970, 2, 3),
				"htotp://www.nioutaik.fr/images/galerie/fail%2002.jpg");
		service.ajouterUnCollegue(c);
	}

}
