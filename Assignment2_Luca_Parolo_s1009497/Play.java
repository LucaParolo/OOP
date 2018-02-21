import java.util.Scanner;

/**
 * Creates a new game controller and implements the logic
 *
 * @author Luca Parolo s1009497
 */

public class Play {

	public void run() {

		Scanner scan = new Scanner(System.in);

		// creates a new game controller
		gameController controller = new gameController();

		// prints the intro to the game
		controller.gameIntro();

		// ask to the user for the game mode
		controller.setGameMode(scan);

		// set the word to play with , random word if gameMode =0
		if (controller.getGameMode() == 0) {

			controller.setRandomWord();
		}
		// if gameMode=1, asks the user to input a word
		if (controller.getGameMode() == 1) {

			controller.setUserWord(scan);
		}

		// creates a StringBuilder of dots of the length of the word
		controller.setWordInProgress();

		// prints the word just created (which is made only of dots)

		wordView.printWordInProgress(controller.getWordInProgress());

		// implements the loop. The integer parameter is the number of wrogn guess to
		// play with. In this case 9

		controller.loop(controller.getWord(), controller.getWordInProgress(), scan, 9);
	}
}
