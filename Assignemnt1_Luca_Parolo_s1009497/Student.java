/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luca Parolo s1009497
 */
public class Student {

	private String name;
	private String surname;
	private int snumber;

	public Student(String name, String surname, int snumber) {

		this.name = name;
		this.surname = surname;
		this.snumber = snumber;

	}

	public String endResult() {
		return name + " " + surname + " , s" + snumber;
	}

	public int getNumber() {

		return this.snumber;
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public void setSurname(String newSurname) {
		this.surname = newSurname;
	}

}
