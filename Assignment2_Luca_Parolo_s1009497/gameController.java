import java.util.Scanner;

/**
 * Controller for the game.
 *
 * @author Luca Parolo s1009497
 */

public class gameController {

	private String word;
	private int gameMode;
	private StringBuilder wordInProgress;
	private int chances;
	private boolean youwin;

	public gameController() {

		this.youwin = false;

	}

	/**
	 * Prints the introduction for the game
	 *
	 */

	public void gameIntro() {

		System.out.println("Hello.\nWelcome to the Hangman game. The aim of the game is to guess a word.\n"
				+ "You can choose to play with a random word or to write a word to play with\n"
				+ "The number of letters in the word you have to guess is represented by the number of dots.\n"
				+ "You can insert any letter. If the letter is in the word , you will see the position of the letter in the word\n"
				+ "If you don't guess right for 10 times you DIE!\n\n ");

	}

	/**
	 * Calls the WordReader and set a random word
	 *
	 * 
	 */

	public void setRandomWord() {

		WordReader wordreader = new WordReader("src/words.txt");

		this.word = wordreader.getWord();

	}

	/**
	 * Sets as word to play with a word chosen by the user
	 *
	 * @param scan
	 * 
	 ***/
	public void setUserWord(Scanner scan) {

		System.out.println("You have chosen to play with you own word. Please type the word you want to play with!");

		scan.nextLine();
		String chosenWord = scan.nextLine().toLowerCase();
		assert (chosenWord.indexOf(" ")<0):"You entered a word with a space. You can only enter one word. PLease try again";

		this.word = chosenWord;

	}

	public String getWord() {

		return this.word;

	}

	/**
	 * Sets the game mode (0 if the player choose a random word, 1 if the player
	 * decides the word)
	 *
	 * @param scan
	 * 
	 ***/
	public void setGameMode(Scanner scan) {

		gameMode gamemode = new gameMode();
		this.gameMode = gamemode.setGameMode(scan);

	}

	public int getGameMode() {

		return this.gameMode;
	}

	/**
	 * Sets a StringBuilder "WordInProgress" of the same length of the String "word"
	 * of dots only During the game this StringBuilder will be modified
	 *
	 * @param scan
	 * 
	 ***/
	public void setWordInProgress() {

		StringBuilder wordInProgress = new StringBuilder();
		for (int i = 1; i <= this.word.length(); i++) {

			wordInProgress.append(".");

		}

		this.wordInProgress = wordInProgress;
	}

	public StringBuilder getWordInProgress() {

		return this.wordInProgress;

	}

	/**
	 * read the guess of the letter of the users. Returns the letter as char
	 * 
	 * @param scan
	 * @return guess
	 ***/

	public char readInput(Scanner scan) {

		String guessString = scan.next();

		assert (guessString.length() == 1) : "You can only write one character. Please restart the game";
		char guess = Character.toLowerCase(guessString.charAt(0));

		return guess;

	}

	/**
	 * Check for correspondence between the guessed letter and the word.If there is
	 * correspondence, updates the StringBuilder wordInProgress. Returns true if
	 * there is correspondence, false otherwise
	 * 
	 * @param guess
	 * @param wordInProgress
	 * @param word
	 * @param chances
	 ***/

	public boolean checkChar(char guess, StringBuilder wordInProgress, String word, int chances) {

		boolean correspondence = false;

		for (int i = 0; i < this.word.length(); i++) {

			char checking = this.word.charAt(i);

			if (guess == checking) {

				String guessString = "" + guess;

				this.wordInProgress.replace(i, i + 1, guessString);
				correspondence = true;
			}

		}

		if (correspondence) {

			wordView.printCorrespondence(this.wordInProgress);
		}

		else if (chances > 0) {
			wordView.printNotCorrespondence(this.chances);

		}

		return correspondence;
	}

	/**
	 * Implements a loop to play. The loop last until the left chances are > 0.
	 * Calls the checkChar function. If there is no correspondence update the value
	 * of chances subtracting 1. Calls also the youWin() function which check if
	 * there are dots left in the wordInProgress. If there are no dots left , means
	 * that the player has win, therefore stops the program.
	 * 
	 * @param scan
	 * @param wordInProgress
	 * @param word
	 * @param chances
	 ***/

	public void loop(String word, StringBuilder wordInProgress, Scanner scan, int chances) {

		this.chances = chances;

		while (this.chances >= 0) {

			boolean correspondence = checkChar(readInput(scan), wordInProgress, word, chances);

			if (correspondence == false) {

				this.chances = this.chances - 1;

			}

			youWin();

			if (getYouWin() == true) {

				System.out.println("         YOU GUESSED THE WORD!!!           \n"
						+ "***************YOU WIN!!!********************");
				System.exit(0);

			}

		}

		wordView.endGame(this.word);
		System.exit(0);

	}

	/**
	 * Check if the user has win looking for remaining dots in the wordInProgress.
	 * If the are no dots left, updated the boolean value youwin as true
	 * 
	 * 
	 ***/

	public void youWin() {

		if (this.wordInProgress.indexOf(".") < 0) {

			this.youwin = true;
		}

	}

	public boolean getYouWin() {

		return this.youwin;
	}
}
