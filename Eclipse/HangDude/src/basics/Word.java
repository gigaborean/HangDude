package basics;

import java.util.HashSet;

public class Word {
	 private String wordString;
	 
	 public Word(String wordString) {
		 this.wordString = wordString;
	 }
	 
	 public boolean contains(Character character) {
		 return wordString.contains(character.toString());
	 }
	 
	 public String onlyIncludeLetters(HashSet<Character> letters) {
		 String output = "";
		 
		 for (Character c : wordString.toCharArray()) {
			 if (letters.contains(c)) {
				 output += c.toString();
			 } else {
				 output += "_";
			 }
		 }
		 
		 return output;
	 }
	 
	 public boolean isGuessed(HashSet<Character> letters) {
		 for (Character c : wordString.toCharArray()) {
			 if (!letters.contains(c)) {
				 return false;
			 }
		 }
		 
		 return true;
	 }
	 
	 public String toString() {
		  return wordString;
	 }

	 public String getWordString() {
		 return wordString;
	 }
}