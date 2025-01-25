package org.example;

import java.util.Set;
import java.util.TreeSet;

public class StudentRepository {
	Set<Student> catalog = new TreeSet<>();

	public void add(Student student) {
		try {
			if (!catalog.add(student)) {
				throw new RuntimeException("This student already exists in the catalog.");
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Some fields are empty or not proper: " + e.getMessage());
		}
	}

	public void delete(long cnp) {
		boolean studentFound = false;
		try {
			for (Student student : catalog) {
				if (student.getCnp() == cnp) {
					catalog.remove(student);
					studentFound = true;
				}
			}
			if (!studentFound) {
				throw new RuntimeException("The student with specified cnp is not in the catalog.");
			}
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	public Set<Student> retreiveAll(String birthDate) {
		return catalog;
	}

	public Set<Student> listOrderedStudents() {
		return null;
	}


}
