package org.example;

import lombok.Getter;

import java.time.LocalDate;
import java.util.Set;

/**
 * The type Catalog administrator.
 * A wrapper for StudentRepository class.
 */
@Getter
public class CatalogAdministrator {
	StudentRepository repository = new StudentRepository();

	public Set<Student> addStudentInCatalog(String firstName, String lastName, LocalDate birthDate, String gender, String cnp) {
		try {
			repository.add(firstName, lastName, birthDate, gender, cnp);
		} catch(RuntimeException e) {
			System.out.println(e.getMessage());
		}
		return repository.getCatalog();
	}

	public Set<Student> deleteStudentFromCatalog(String cnp) {
		try {
			repository.delete(cnp);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		return repository.getCatalog();
	}

	@Override
	public String toString() {
		return "CatalogAdministrator{" +
				"catalog=" + repository.getCatalog() +
				'}';
	}
}
