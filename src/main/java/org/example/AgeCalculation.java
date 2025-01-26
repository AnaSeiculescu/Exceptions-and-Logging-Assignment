package org.example;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class AgeCalculation {

	public int getAgeFromBirthday(LocalDate birthDate) {
		int birthYear = birthDate.getYear();
		int todayYear = LocalDate.now().getYear();
		int age = todayYear - birthYear;
		return age;
	}
}
