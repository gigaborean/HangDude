package controllers;

import java.util.HashSet;

import basics.Word;

public class GuessContainer {
	private Word word;
	private HashSet<Character> guessedLetters = new HashSet<Character>();
	private int maxAllowedGuesses = 10;
	private int failed = 0;
	
	public GuessContainer(Word word) {
		this.word = word;
	}
	
	public boolean makeGuess(Character letter) {
		if (guessedLetters.contains(letter)) {
			return false;
		}
		
		guessedLetters.add(letter);
		
		if (word.contains(letter)) {
			return true;
		} else {
			failed ++;
			return false;
		}
	}
	
	public HashSet<Character> getGuessedLetters() {
		return guessedLetters;
	}
	
	public int failedCount() {
		return failed;
	}
	
	public boolean isMaxExceeded() {
		return failed >= maxAllowedGuesses;
	}
}
