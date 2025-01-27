package org.example;

import org.junit.Test;

import java.time.LocalDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class StudentRepositoryTest {

	@Test
	public void testAddOneStudentTwice() {
		// prepare
		StudentRepository repository = new StudentRepository();
		LocalDate birthDate1 = LocalDate.of(1986, 11, 28);

		//execute
		repository.add("Ilie", "Cernea", birthDate1, "male", "1861128364169");
		Exception exception = assertThrows(RuntimeException.class, () -> {
			repository.add("Ilie", "Cernea", birthDate1, "male", "1861128364169");
		});

		//verify
		assertEquals("Student: Ilie Cernea, already exists in the catalog.", exception.getMessage());
	}
}