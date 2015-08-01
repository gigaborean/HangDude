package controllers;

import java.util.List;
import java.util.Random;

import basics.Word;
import main.ReadWriter;

public class GameController {
	private ReadWriter readWriter = new ReadWriter();
	private Word word;
	private GuessContainer guessContainer;
	private List<String> dictionary;
	private Random r = new Random();
	
	public GameController() {
		dictionary = readWriter.getDictionary();
	}
	
	private String getRandomWord () {
		int totalWords = dictionary.size();
		int index = r.nextInt(totalWords);
		return dictionary.get(index);
	}
	
	public void runGame() {
		boolean wordGuessed = false;
		newGame();
		
		while (true) {
			outputRemaining();
			makeGuess();
			
			if (word.isGuessed(guessContainer.getGuessedLetters())) {
				wordGuessed = true;
				break;
			}
			
			if (guessContainer.isMaxExceeded()) break;
		}
		
		endGame(wordGuessed);
	}
	
	private void newGame() {
		readWriter.writeline("Generating Word...");
		String wordString = getRandomWord ();
		
		word = new Word(wordString);
		guessContainer = new GuessContainer(word);
	}
	
	private void outputRemaining() {
		readWriter.writeline("Word: " + word.onlyIncludeLetters(guessContainer.getGuessedLetters()));
	}
	
	private void makeGuess() {
		while (true) {
			readWriter.writeline("Input next guess (failed " + guessContainer.failedCount() + "): ");
			String letter = readWriter.readline();
			
			if (letter.length() != 1) {
				readWriter.writeline("Input only ONE letter!!");
				continue;
			}
			
			guessContainer.makeGuess(letter.toCharArray()[0]);
			break;
		}
	}
	
	private void endGame(boolean wordGuessed) {
		if (wordGuessed) {
			readWriter.writeline("YOU WIN!");
		} else {
			readWriter.writeline("GAME OVER!");
		}
	
		readWriter.writeline("The word was: " + word.toString());
	}
}
