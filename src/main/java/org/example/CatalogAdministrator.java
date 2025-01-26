package org.example;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CatalogAdministrator {
	StudentRepository catalog = new StudentRepository();

	public void addStudentInCatalog(String firstName, String lastName, LocalDate birthDate, String gender, String cnp) {
		try {
			catalog.add(firstName, lastName, birthDate, gender, cnp);
		} catch(RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	public void deleteStudentFromCatalog(String cnp) {
		try {
			catalog.delete(cnp);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public String toString() {
		return "CatalogAdministrator{" +
				"catalog=" + catalog +
				'}';
	}
}
