package org.example;

import lombok.Getter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
public class Student {
	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	private String gender;
	private String cnp;

	public Student(String firstName, String lastName, LocalDate birthDate, String gender, String cnp) {
		setFirstName(firstName);
		setLastName(lastName);
		setBirthDate(birthDate);
		setGender(gender);
		setCnp(cnp);
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
		if (birthDate == null) {
			throw new IllegalArgumentException("Birth date cannot be null.");
		}
		if (birthDate.getYear() <= 1900) {
			throw new IllegalArgumentException("The year of birth should be after 1900.");
		}
		if (birthDate.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("The year of birth should not be in the future.");
		}
		this.birthDate = birthDate;
	}

	public void setGender(String gender) {
		boolean genderFound = false;
		for (Gender currentGender : Gender.values()) {
			if (gender.toUpperCase().equals(currentGender.toString())) {
				this.gender = Gender.valueOf(gender.toUpperCase()).toString();
				genderFound = true;
			}
		}
		if (!genderFound) {
			throw new IllegalArgumentException("The gender provided should be male or female");
		}
	}

	public void setCnp(String cnp) {
		if (cnp.length() != 13) {
			throw new IllegalArgumentException("CNP should not be an empty filed or have less or more than 10 digits.");
		}
		String regex = "\\d+";
		if (!cnp.matches(regex)) {
			throw new IllegalArgumentException("CNP should contain only digits: ");
		}
		this.cnp = cnp;
	}

	@Override
	public String toString() {
		return "\nStudent{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", birthDate=" + birthDate +
				", gender='" + gender + '\'' +
				", cnp=" + cnp +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Student student = (Student) o;
		return Objects.equals(getLastName(), student.getLastName()) || Objects.equals(getBirthDate(), student.getBirthDate());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getLastName(), getBirthDate());
	}
}
