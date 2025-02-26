package org.example;

import java.util.Comparator;

public class StudentsComparator implements Comparator <Student>{
	public int compare(Student student1, Student student2) {
		if (student1.getLastName().equals(student2.getLastName())) {
			return student1.getBirthDate().compareTo(student2.getBirthDate());
		}
		return student1.getLastName().compareTo(student2.getLastName());
	}
}
