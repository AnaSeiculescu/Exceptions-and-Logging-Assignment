package org.example;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;


@Getter
public class Student {
	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	private Gender gender;
	@Setter
	private long cnp;

	public Student(String firstName, String lastName, LocalDate birthDate, Gender gender, long cnp) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.gender = gender;
		this.cnp = cnp;
	}

	public void setFirstName(String firstName) {
		if (firstName.isEmpty()) {
			throw new IllegalArgumentException("First name should not be empty.");
		}
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		if (lastName.isEmpty()) {
			throw new IllegalArgumentException("Last name should not be empty.");
		}
		this.lastName = lastName;
	}

	public void setBirthDate(LocalDate birthDate) {
		if (birthDate.getYear() <= 1900) {
			throw new IllegalArgumentException("The yer of birth should be after 1900.");
		}
		this.birthDate = birthDate;
	}

	public void setGender(String gender) {
		for (Gender currentGender : Gender.values()) {
			if (gender.equals(currentGender.toString().toUpperCase())) {
				this.gender = Gender.valueOf(gender.toUpperCase());
			} else {
				throw new IllegalArgumentException("The gender provided should be male or female");
			}
		}
	}
}
