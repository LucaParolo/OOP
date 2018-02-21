/**
 * Prints messages in the console
 *
 * @author Luca Parolo s1009497
 */
public class wordView {

	/**
	 * Prints the wordInProgress (which is only dots). Is called only once at the
	 * beginning of the game
	 *
	 * @param wordInProgress
	 */
	public static void printWordInProgress(StringBuilder wordInProgress) {

		System.out.println("The word to guess is : " + wordInProgress);

	}

	/**
	 * Prints the version of the message when there IS correspondence between the
	 * guess of the user and letters in the word to guess
	 *
	 * @param wordInProgress
	 */
	public static void printCorrespondence(StringBuilder wordInProgress) {

		System.out.println("Well Done!You guessed right!\n" + "The word to guess is : " + wordInProgress);

	}

	/**
	 * Prints the version of the message when there is IS NOT correspondence between
	 * the guess of the user and letters in the word to guess
	 *
	 * @param chances
	 */
	public static void printNotCorrespondence(int chances) {

		if (chances > 0) {
			System.out.println(
					"You didn't guessed right :(  You still have " + chances + " wrong guess before we kill you");

		}
	}

	/**
	 * Prints the version of the message when the GAME IS OVER
	 * 
	 *
	 * @param word
	 */
	public static void endGame(String word) {

		System.out.println("Oh no, you finished your chances!!! The word was  '" + word.toUpperCase()
				+ "'  You will DIE!!!!!!" + "\n********************************" + "\n********************************"
				+ "\n********************************" + "\n***********GAME OVER************"
				+ "\n********************************" + "\n********************************"
				+ "\n********************************");

	}
}
