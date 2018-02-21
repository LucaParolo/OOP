import java.util.Scanner;

/**
 * Asks the user what mode of the game to play
 *
 * @author Luca Parolo s1009497
 */

public class gameMode {

	public int setGameMode(Scanner scan) {

		System.out.println("Please choose the game mode. \n" + "Type 0 if you want a random word\n"
				+ "Type 1 if you want to choose your own word");

		int choice = scan.nextInt();
		assert (choice == 0 || choice == 1) : "Please insert a valid number. Type 0 if you want a random word\n"
				+ "Type 1 if you want to choose your own word";

		return choice;

	}

}
