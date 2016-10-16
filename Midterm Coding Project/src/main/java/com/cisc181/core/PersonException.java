package com.cisc181.core;

public class PersonException extends Exception {
	
	private Person Person;
	
	public PersonException(Person person) {
		this.Person = person;
	}
	
	public Person getPerson() {
		return Person;
	}

}
