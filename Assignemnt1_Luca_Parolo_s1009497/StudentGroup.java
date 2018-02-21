
import java.util.Scanner;

/**
 *
 * @author Luca Parolo s1009497
 */
public class StudentGroup {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int size = groupSizeInput(scan);
		Student[] studentGroup = new Student[size];

		buildGroup(studentGroup, scan);

		printGroup(studentGroup);

		loopChange(studentGroup, scan, size);

	}

	/**
	 * Ask the user the size of the student group
	 * 
	 * @param scan
	 * @return groupSize
	 */
	public static int groupSizeInput(Scanner scan) {

		System.out.println("Please enter the number of students in the group");

		int groupSize = scan.nextInt();
		scan.nextLine();
		return groupSize;

	}

	/**
	 * Build the group of students of given size
	 * 
	 * @param scan
	 * @param studenGroup
	 * 
	 */
	public static void buildGroup(Student[] studentGroup, Scanner scan) {

		for (int i = 0; i < studentGroup.length; i++) {

			String[] nameSurname = askName(scan);
			String name = nameSurname[0];
			String surname = nameSurname[1];
			int snumber = askNumber(scan);

			studentGroup[i] = new Student(name, surname, snumber);
		}
	}

	/**
	 * Ask the name and the surname of one student. Returns both in a array
	 * 
	 * @param scan
	 * @return nameSurname
	 */
	public static String[] askName(Scanner scan) {

		System.out.println("What's the name and the surname of the next student? ");
		String nameSur = scan.nextLine();
		String[] nameSurname = nameSur.split(" ");
		assert (nameSurname.length == 2) : "Please insert exactly one name and one surname";

		return (nameSurname);

	}

	/**
	 * Ask for the student number of the student
	 * 
	 * @param scan
	 * @return number
	 */
	public static int askNumber(Scanner scan) {

		System.out.println("What's the number of the student ?");
		int number = scan.nextInt();
		scan.nextLine();
		return number;

	}

	/**
	 * Scan next line and returns an array of length 3 with number of the student
	 * ,(new) name and (new) surname
	 * 
	 * @param scan
	 * @return
	 */
	public static String[] numberNewName(Scanner scan) {

		String numName = scan.nextLine();
		String[] parts = numName.split(" ");
		assert parts.length == 3 : "You MUST insert a number,a name and a surname, please try again!";
		return parts;

	}

	/**
	 * Takes the array with number of the student ,(new) name and (new) surname, and
	 * returns only the name
	 * 
	 * @param parts
	 * @return newName
	 */
	public static String newName(String[] parts) {

		String newName = parts[1];
		assert newName != null : "The (new) name MUST be declared";
		return newName;

	}

	/**
	 * Takes the array with number of the student ,(new) name and (new) surname, and
	 * returns only the surname
	 * 
	 * @param parts
	 * @return newSurname
	 */
	public static String newSurname(String[] parts) {

		String newSurname = parts[2];
		assert newSurname != null : "The (new) surname MUST be declared";
		return newSurname;

	}

	/**
	 * Takes the array with number of the student ,(new) name and (new) surname, and
	 * returns only the number of the student
	 * 
	 * @param parts
	 * @return numToChange
	 */
	public static int numStudToChange(String[] parts) {

		int numToChange = Integer.parseInt(parts[0]);
		return numToChange;
	}

	/**
	 * Prints all the students in the student group
	 * 
	 * @param studentGroup
	 * 
	 */
	public static void printGroup(Student[] studentGroup) {

		System.out.println("The group now contains: \n");

		for (int i = 0; i < studentGroup.length; i++) {

			String result = studentGroup[i].endResult();
			System.out.println(result);
		}

	}

	/**
	 * Ask in a loop for the number of the student whose name and surname have to be changed
	 * and for the new name and surname.
	 * 
	 * @param studentGroup
	 * @param scan
	 * @param size
	 */
	public static void loopChange(Student[] studentGroup, Scanner scan, int size) {

		while (true) {

			System.out.println("Enter the student number of the student you want to change "
					+ "the name and the new name (and/or) new surname?\n"
					+ "Enter a negative student number to terminate the programme");

			String[] numNewName = numberNewName(scan);
			String newName = newName(numNewName);
			String newSurname = newSurname(numNewName);
			int numtochange = numStudToChange(numNewName);

			for (int i = 0; i < size; i++) {

				if (numtochange < 0) {
					System.out.println("You inserted a negative student number, programme is terminated");
					scan.close();
					System.exit(0);
				}

				else if (studentGroup[i].getNumber() == numtochange) {
					studentGroup[i].setName(newName);
					studentGroup[i].setSurname(newSurname);
					printGroup(studentGroup);

				}

				else {
					System.out.println("We haven't find any match for the student number you inserted, try again");
				}

			}

		}
	}
}
