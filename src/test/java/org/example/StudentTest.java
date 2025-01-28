package org.example;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class StudentTest {

	@Test
	public void testCreateStudentInvalidCnp() {
		// prepare
		LocalDate birthDate1 = LocalDate.of(1986, 11, 28);

		//execute
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			new Student("Ilie", "Cernea", birthDate1, "male", "186112836416x");
		});

		//verify
		assertEquals("CNP should contain only digits.", exception.getMessage());
	}
}