/**
 * 
 */
package com.diginamic.main.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.diginamic.main.model.Collegue;

/**
 * @author Guillaume
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class CollegueRepositoryIntegrationTest {

	@Autowired
	private CollegueRepository repository;

	/**
	 * Test method for
	 * {@link com.diginamic.main.repository.CollegueRepository#findByNom(java.lang.String)}.
	 */
	@Test
	public void testFindByNom() {
		String nom = UUID.randomUUID().toString();
		repository.save(new Collegue(UUID.randomUUID().toString(), nom, "ggg", "fff@", LocalDate.now(), "http"));
		List<Collegue> liste = repository.findByNom(nom);
		assertThat(liste.size()).isEqualTo(1);
	}

	@Test
	public void testFindByNomNonTrouve() {
		String nom = UUID.randomUUID().toString();
		repository.save(new Collegue(UUID.randomUUID().toString(), nom, "ggg", "fff@", LocalDate.now(), "http"));
		List<Collegue> liste = repository.findByNom("123");
		assertThat(liste.size()).isEqualTo(0);
	}

}
