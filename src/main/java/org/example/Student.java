package org.example;

import lombok.Getter;

@Getter
public class Student {
	private String firstName;
	private String lastName;
	private String birthDate;
	private String gender;
	private long cnp;

	public Student(String firstName, String lastName, String dateOfBirth, String gender, long cnp) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = dateOfBirth;
		this.gender = gender;
		this.cnp = cnp;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setCnp(long cnp) {
		this.cnp = cnp;
	}

}
