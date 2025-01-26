package org.example;

import lombok.Getter;

import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

@Getter

public class StudentRepository {
	private final Set<Student> catalog = new TreeSet<>(new StudentsComparator());
	private final AgeCalculation ageCalculation = new AgeCalculation();

	public Set<Student> add(String firstName, String lastName, LocalDate birthDate, String gender, String cnp) {
		try {
			Student student = new Student(firstName, lastName, birthDate, gender, cnp);
			if (!catalog.add(student)) {
				throw new RuntimeException("Student: " + student.getFirstName() + " " + student.getLastName() + ", already exists in the catalog.");
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Some fields are empty or not proper: " + e.getMessage());
		}
		return catalog;
	}

	public Set<Student> delete(String cnp) {
		boolean studentFound = false;

		if (catalog.removeIf(student -> student.getCnp().equals(cnp))) {
			studentFound = true;
		}
		if (!studentFound) {
			throw new IllegalArgumentException("The student with specified cnp is not in the catalog.");
		}
		return catalog;
	}

	public Set<Student> retrieveAllWithSpecificAge(int age) {
		Set<Student> studentsWithSpecificBirthDate = new TreeSet<>(new StudentsComparator());

		for (Student student : catalog) {
			if (ageCalculation.getAgeFromBirthday(student.getBirthDate()) == age) {
				studentsWithSpecificBirthDate.add(student);
			}
		}
		return studentsWithSpecificBirthDate;
	}

	@Override
	public String toString() {
		return "StudentRepository{" +
				"catalog=" + catalog +
				'}';
	}
}
