/**
 * 
 */
package com.diginamic.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diginamic.main.model.Collegue;

/**
 * @author Guillaume
 *
 */
public interface CollegueRepository extends JpaRepository<Collegue, String> {

	public List<Collegue> findByNom(String nom);

}
