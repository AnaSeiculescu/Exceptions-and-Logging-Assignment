package org.example;


import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CatalogAdministratorTest {

	@Test
	public void testAddStudentInCatalogHappyPathOneInput() {
		// prepare
		StudentRepository repository = new StudentRepository();

		LocalDate birthDate1 = LocalDate.of(1986, 11, 28);

		//execute
		repository.add("Ilie", "Cernea", birthDate1, "male", "1861128364169");

		String expectedResult = "StudentRepository{catalog=[\nStudent{firstName='Ilie', lastName='Cernea', birthDate=1986-11-28, gender='MALE', cnp=1861128364169}]}";
		String actualResult = repository.toString();

		//verify
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testAddStudentInCatalogHappyPathTwoInput() {
		// prepare
		StudentRepository repository = new StudentRepository();

		LocalDate birthDate1 = LocalDate.of(1986, 11, 28);
		LocalDate birthDate3 = LocalDate.of(1985, 11, 28);

		//execute
		repository.add("Ilie", "Cernea", birthDate1, "male", "1861128364169");
		repository.add("Paul", "Cernea", birthDate3, "male", "1851128364129");

		String expectedResult = "StudentRepository{catalog=[\nStudent{firstName='Paul', lastName='Cernea', birthDate=1985-11-28, gender='MALE', cnp=1851128364129}, \nStudent{firstName='Ilie', lastName='Cernea', birthDate=1986-11-28, gender='MALE', cnp=1861128364169}]}";
		String actualResult = repository.toString();

		//verify
		assertEquals(expectedResult, actualResult);
	}

}