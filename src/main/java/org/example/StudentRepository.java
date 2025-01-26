package org.example;

import lombok.Getter;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

@Getter

public class StudentRepository {
//	private Student student = new Student();
	private final Set<Student> catalog = new TreeSet<>(new Comparator<Student>() {
		@Override
		public int compare(Student student1, Student student2) {
			if (student1.getLastName().equals(student2.getLastName())) {
				return student1.getBirthDate().compareTo(student2.getBirthDate());
			}
			return student1.getLastName().compareTo(student2.getLastName());
		}
	});

	public void add(String firstName, String lastName, LocalDate birthDate, String gender, String cnp) {
		try {
			Student student = new Student(firstName, lastName, birthDate, gender, cnp);
			if (!catalog.add(student)) {
				throw new RuntimeException("Student: " + student.getFirstName() + " " + student.getLastName() + ", already exists in the catalog.");
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Some fields are empty or not proper: " + e.getMessage());
		}
	}

	public void delete(String cnp) {
		boolean studentFound = false;

		for (Student student : catalog) {
			if (student.getCnp() == cnp) {
				catalog.remove(student);
				studentFound = true;
			}
		}
		if (!studentFound) {
			throw new IllegalArgumentException("The student with specified cnp is not in the catalog.");
		}
	}

	public Set<Student> retreiveAll(String birthDate) {
		return catalog;
	}

	public Set<Student> listOrderedStudents() {
		return catalog;
	}

	@Override
	public String toString() {
		return "StudentRepository{" +
				"catalog=" + catalog +
				'}';
	}
}
